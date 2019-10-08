package com.example.app.serviceimpl;

import com.example.app.commons.Constant;
import com.example.app.commons.HttpClientUtil;
import com.example.app.commons.JsonUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.QrCodeMapper;
import com.example.app.model.QrCode;
import com.example.app.service.QrCodeService;
@Service
public class QrCodeServiceImpl implements QrCodeService{

    @Resource
    private QrCodeMapper qrCodeMapper;


    @Override
    public QrCode updateQrcode(Integer wx_id) {
        String q_code="";
        String expire_seconds="2592000";
        QrCode qrCode = qrCodeMapper.selectByPrimaryKey(wx_id);
        if(qrCode ==null){
            QrCode qRcode = getQRcode(wx_id, expire_seconds);
            qRcode.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
            qRcode.setWxId(wx_id);
            qRcode.setExpireSeconds("2592000");

            qrCodeMapper.insert(qRcode);

        }else {

            long nowTime=System.currentTimeMillis()/1000;
            long getTime=Long.valueOf(qrCode.getCreateTime());
            long yesTime=Long.valueOf(qrCode.getExpireSeconds());
            if(nowTime-getTime>yesTime){
                QrCode qRcode = getQRcode(wx_id, expire_seconds);
                qRcode.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
                qRcode.setWxId(wx_id);
                qRcode.setExpireSeconds("2592000");
                qrCodeMapper.updateByPrimaryKey(qrCode);

            }
        }


        return qrCodeMapper.selectByPrimaryKey(wx_id);
    }

    @Override
    public QrCode selectByid(Integer id) {
        return qrCodeMapper.selectByid(id);
    }

    private  QrCode getQRcode(Integer wx_id,String expire_seconds){

        String  url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ Constant.getAcccess_token();
        String data="{\"expire_seconds\": "+expire_seconds+", \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": "+wx_id+"}}}";
        JSONObject jsonObject = HttpClientUtil.doPost(url, data);
        QrCode qrCode = JsonUtil.fromJson(jsonObject.toString(), QrCode.class);
        return qrCode;
    }
}
