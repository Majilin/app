package com.example.app.commons;

import com.example.app.model.WxUser;
import com.example.app.service.WxUserService;
import com.example.app.serviceimpl.WxUserServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class MessageManagement {
    @Autowired
    private   WxUserService wxUserService;

    public static MessageManagement messageManagement;
    @PostConstruct
    public void init(){
        messageManagement=this;
        messageManagement.wxUserService=this.wxUserService;
    }

    private static   String  updatemsg(String event, WxUser wxUser1, String fromUserName, String toUserName) {
        String xml = "";
        System.out.println("进入事件消息");
        if (event.equals("subscribe")) {
            System.out.println("进入关注状态");
            //######################################Get方式请求#################################
            String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + Constant.getAcccess_token() + "&openid=" + fromUserName + "&lang=zh_CN";
            JSONObject jsonObject = HttpClientUtil.doGet(url);
            WxUser wxUser = JsonUtil.fromJson(jsonObject.toString(), WxUser.class);
            if (wxUser1 != null) {
                wxUser1.setSubscribe(1);
                messageManagement.wxUserService.updateByPrimaryKeySelective(wxUser1);
                System.out.println("更新成功！！！！");
            } else {
                messageManagement.wxUserService.insertSelective(wxUser);
                System.out.println("插入成功！！！！");
            }
            xml = "<xml>\n" +
                    "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                    "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                    "  <CreateTime>12345678</CreateTime>\n" +
                    "  <MsgType><![CDATA[news]]></MsgType>\n" +
                    "  <ArticleCount>2</ArticleCount>\n" +
                    "  <Articles>\n" +
                    "    <item>\n" +
                    "      <Title><![CDATA[最大图标]]></Title>\n" +
                    "      <Description><![CDATA[描述最大图标]]></Description>\n" +
                    "      <PicUrl><![CDATA[http://irn9uu1.hn3.mofasuidao.cn/bbb/images/facepic.jpg]]></PicUrl>\n" +
                    "      <Url><![CDATA[http://irn9uu1.hn3.mofasuidao.cn/bbb/index.html]]></Url>\n" +
                    "    </item>\n" +
                    "    <item>\n" +
                    "      <Title><![CDATA[第二图标]]></Title>\n" +
                    "      <Description><![CDATA[描述第二大图标]]></Description>\n" +
                    "      <PicUrl><![CDATA[http://irn9uu1.hn3.mofasuidao.cn/bbb/images/user-logo-004.png]]></PicUrl>\n" +
                    "      <Url><![CDATA[http://irn9uu1.hn3.mofasuidao.cn/bbb/pcenter.html]]></Url>\n" +
                    "    </item>\n" +
                    "  </Articles>\n" +
                    "</xml>";
        } else if (event.equals("unsubscribe")) {
            System.out.println("进入取消关注状态");
            if (wxUser1 != null) {
                wxUser1.setSubscribe(0);
                messageManagement.wxUserService.updateByPrimaryKeySelective(wxUser1);
            } else {
                System.out.println("出错了");
            }
        }
        return xml;
    }
    public static String managementMsg(String msgType, String event, WxUser wxUser1, String fromUserName, String toUserName) {
        String xml = "";
        if (msgType.equals("event")) {
           xml= updatemsg(event, wxUser1, fromUserName,toUserName);
        } else if (msgType.equals("image")) {
            System.out.println("进入图片消息");
        } else if (msgType.equals("text")) {
            System.out.println("进入文本消息");
            xml = "<xml>" +
                    "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>" +
                    "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>" +
                    "  <CreateTime>12345678</CreateTime>" +
                    "  <MsgType><![CDATA[text]]></MsgType>" +
                    "  <Content><![CDATA[马什么梅]]></Content>" +
                    "</xml>";
        } else if (msgType.equals("voice")) {
            System.out.println("进入使声音消息");
        } else if (msgType.equals("video")) {
            System.out.println("进入视频消息");
        } else if (msgType.equals("shortvideo")) {
            System.out.println("进入小视频消息");
        } else if (msgType.equals("location")) {
            System.out.println("进入当地消息");
        } else if (msgType.equals("link")) {
            System.out.println("进入链接消息");
        }

        return xml;
    }
}
