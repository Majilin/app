package com.example.app.serviceimpl;

import com.example.app.commons.Constant;
import com.example.app.commons.HttpClientUtil;
import com.example.app.commons.JsonUtil;
import com.example.app.mapper.*;
import com.example.app.model.*;
import org.jdom2.CDATA;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.app.service.MessageService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private WxUserMapper wX_UserMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private QrCodeMapper qrCodeMapper;
    @Autowired
    private SharetableMapper sharetableMapper;

    @Autowired
    private UsercreditMapper usercreditMapper;

    @Autowired
    private SigninMapper signinMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public String messageHandle(Element root) {
        //开发者微信号
        String toUserName = root.getChildText("ToUserName");
        //用户的openid
        String fromUserName = root.getChildText("FromUserName");
        //消息创建时间
        String createTime = root.getChildText("CreateTime");
        //消息类型（值为event时消息类型为事件类型）
        String msgType = root.getChildText("MsgType");
        //当消息类型为事件类型时，有值
        String event = root.getChildText("Event");
        //根据openid查询用户是否存在
        WxUser d_wx_user = wX_UserMapper.selectByOpenId(fromUserName);
        //被动回复消息
        String resultXml = "";
        if (msgType.equals("event")) {
            String eventKey = root.getChildText("EventKey");
            String ticket = root.getChildText("Ticket");
            //关注和取消关注事件对用户进行操作
            subscribeMsg(event, d_wx_user, fromUserName, eventKey, ticket);
            // if(d_wx_user!=null&&d_wx_user.getSubscribe()!=1){
            //查询关注的推送消息
            List<Message> list = messageMapper.selectMessagePush("0");
            resultXml = createResultXml(list, fromUserName, toUserName, "news");
            // }
        } else if (msgType.equals("text")) {
            //文本消息内容
            String content = root.getChildText("Content");
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("image")) {
            //进入图片消息
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("voice")) {
            //进入语音消息
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("video")) {
            //进入视频消息
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("shortvideo")) {
            //进入小视频消息
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("location")) {
            //进入地理位置消息
            //TUDO 获取消息内容，定义返回信息
        } else if (msgType.equals("link")) {
            //进入连接消息
            //TUDO 获取消息内容，定义返回信息
        }

        // session.setAttribute("wx_user", wX_UserMapper.selectByOpenId(fromUserName));

        //最终返回需要推送的内容
        return resultXml;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return 0;
    }

    /**
     * 遍历list，创建xml格式字符串
     *
     * @param list
     * @return
     */
    private String createResultXml(List<Message> list, String fromUserName, String toUserName, String msgType) {
        //创建xml 等节点
        Element xml = new Element("xml");
        xml.addContent(new Element("ToUserName").addContent(new CDATA(fromUserName)));
        xml.addContent(new Element("FromUserName").addContent(new CDATA(toUserName)));
        xml.addContent(new Element("CreateTime").addContent(new CDATA(String.valueOf(System.currentTimeMillis()))));
        xml.addContent(new Element("MsgType").addContent(new CDATA(msgType)));
        xml.addContent(new Element("ArticleCount").addContent(String.valueOf(list.size())));
        Element articles = new Element("Articles");
        //循环取出数据，放入articles节点
        for (int i = 0; i < list.size(); i++) {
            Message message = list.get(i);
            Element item = new Element("item");
            item.addContent(new Element("Title").addContent(new CDATA(message.getTitle())));
            item.addContent(new Element("Description").addContent(new CDATA(message.getDescription())));
            try {

                String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constant.APPID + "&redirect_uri=" +  URLEncoder.encode(message.getUrl(), "utf-8")+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
                item.addContent(new Element("Url").addContent(new CDATA(url)));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            item.addContent(new Element("PicUrl").addContent(new CDATA(message.getPicurl())));

            articles.addContent(item);
        }
        //将articles节点放入xml节点内
        xml.addContent(articles);
        // 设置xml文件的字符为UTF-8，解决中文问题
        Format format = Format.getCompactFormat();
        format.setEncoding("UTF-8");
        XMLOutputter xmlout = new XMLOutputter();
        //转为String类型的xml格式
        return xmlout.outputString(xml);
    }
    /**
     * 关注和取消关注事件操作
     *
     * @param event
     * @param d_wx_user
     * @param openid
     */
    private void subscribeMsg(String event, WxUser d_wx_user, String openid, String eventKey, String ticket) {
        if (event.equals("subscribe")) {
            //用户没有关注过，获取用户基本信息
            //System.out.println(eventKey);
            //get请求此路径（url）依据ACCESS_TOKEN和openid来获取当前用户的基本信息
            String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + Constant.getAcccess_token() + "&openid=" + openid + "&lang=zh_CN";//openid 与 fromUserName相等
            JSONObject jsonObject = HttpClientUtil.doGet(url);
            //json转对象
            WxUser wx_user = JsonUtil.fromJson(jsonObject.toString(), WxUser.class);
            //判断用户是否存在（存在于数据库但是取消关注的用户）
            if (d_wx_user == null) {
                // d_wx_user=new WxUser();
                wX_UserMapper.insert(wx_user);

                //如果新用户关注，在用户积分表，插入当前用户的id和积分
                Usercredit usercredit=new Usercredit();
                usercredit.setUid(wx_user.getId());
                usercredit.setIntegral(200);
                usercreditMapper.insert(usercredit);
                //如果新用户关注，在签到表，插入当前用户的id和设置默认签到天数，状态
                Signin signin=new Signin();
                signin.setUid(wx_user.getId());
                signin.setDay(0);
                signin.setStatus(1);
                signinMapper.insert(signin);
                String[] str = eventKey.split("_");
                if (str.length > 1) {
                    String scene_id = str[1];//获取场景值
                    QrCode qrCode = qrCodeMapper.selectByPrimaryKey(Integer.valueOf(scene_id));
                    System.out.println(qrCode.toString()+"qqqqqqqqqqqqqqqqqqq");
                    Sharetable sharetable=new Sharetable();
                    sharetable.setfId(qrCode.getWxId());
                    sharetable.setsId(wx_user.getId());
                    sharetableMapper.insert(sharetable);

                }
                //新增关注用户
                System.out.println("插入成功！！！！！");
            } else {
                //用户之前关注过，修改信息
                d_wx_user.setSubscribe(1);
                wX_UserMapper.updateByPrimaryKeySelective(wx_user);
                System.out.println("更新成功！！！！！");
            }
            // d_wx_user = wx_user;
        } else if (event.equals("unsubscribe")) {
            //修改用户的关注状态为0
            d_wx_user.setSubscribe(0);
            wX_UserMapper.updateByPrimaryKeySelective(d_wx_user);
            return;
        }
    }
}
