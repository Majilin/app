package com.example.app.serviceimpl;

import com.example.app.mapper.WxUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.WxUser;

import com.example.app.service.WxUserService;
@Service
public class WxUserServiceImpl implements WxUserService{

    @Resource
    private WxUserMapper wxUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return wxUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WxUser record) {
        return wxUserMapper.insert(record);
    }

    @Override
    public int insertSelective(WxUser record) {
        return wxUserMapper.insertSelective(record);
    }

    @Override
    public WxUser selectByPrimaryKey(Integer id) {
        return wxUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WxUser record) {
        return wxUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WxUser record) {
        return wxUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public WxUser selectByOpenId(String openid) {
        WxUser wxUser= wxUserMapper.selectByOpenId(openid);
        if(wxUser!=null){
           return wxUser;
        }
        return wxUser;
    }
}
