package com.example.app.controller;

import com.example.app.commons.Constant;
import com.example.app.commons.HttpClientUtil;
import com.example.app.commons.JsonUtil;
import com.example.app.commons.MessageManagement;
import com.example.app.model.JsonType;
import com.example.app.model.QrCode;
import com.example.app.model.WeChatType;
import com.example.app.model.WxUser;
import com.example.app.service.MessageService;
import com.example.app.service.QrCodeService;
import com.example.app.service.WxUserService;
import com.example.app.serviceimpl.MessageServiceImpl;
import com.example.app.serviceimpl.QrCodeServiceImpl;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Resource(name = "wxUserServiceImpl")
    WxUserService wxUserService;
    @Resource(name = "messageServiceImpl")
    MessageService messageService;
    @Resource(name = "qrCodeServiceImpl")
    QrCodeService qrCodeService;

    /***
     * 测试nginx
     * nginx   调用静态资源的绝对路径 /bbb/ 访问反向代理服务器 /app/
     * * @param name
     * @return
     */
    @RequestMapping("index")
    public JsonType index(String name) {
        System.out.println(name);
        return new JsonType("成功", "200", "OK");
    }

    /*
     *一、项目与微信握手sha1加密
     * 1、设置接口配置信息修改填写服务器的Url Token
     * （1）URL   http://irn9uu1.hn3.mofasuidao.cn/app/index.do 接口请求路径   是开发者用来接收微信的信息与事件
     *（2）Token  16                     之后点击提交
     *2、获取微信客户端用Get方式传递的四个参数封装成对象WeChatType weChatType
     * */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexGet(WeChatType weChatType) {
        boolean flag = weChatType.checkinfo();//
        if (flag) {
            return weChatType.getEchostr();//返回随机字符串
        }
        return "";
    }
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String indexToken(HttpServletRequest request) {
        String xml = "";
        try {
            xml = messageService.messageHandle(new SAXBuilder().build(request.getInputStream()).getRootElement());
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
        return xml;
    }
    @RequestMapping(value = "code", method = RequestMethod.POST)
    public String code(String code, HttpSession session) {
        WxUser wx_user = (WxUser) session.getAttribute("wx_user");
        System.out.println("获取Session:"+wx_user);
        System.out.println("获取code:"+code);
        if (wx_user == null) {
            if (code != null) {
                String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constant.APPID + "&secret=" + Constant.APPSECERT + "&code=" + code + "&grant_type=authorization_code";
                JSONObject jsonObject = HttpClientUtil.doGet(url);
                WxUser wxUser = wxUserService.selectByOpenId(jsonObject.get("openid").toString());
                if (wxUser == null) {
                    String url1 = "https://api.weixin.qq.com/sns/userinfo?access_token=" + jsonObject.get("access_token").toString() + "&openid=" + jsonObject.get("openid") + "&lang=zh_CN";
                    JSONObject jsonObject1 = HttpClientUtil.doGet(url1);
                    WxUser wxUser1 = JsonUtil.fromJson(jsonObject1.toString(), WxUser.class);
                    wxUserService.insertSelective(wxUser1);
                }
                    session.setAttribute("wx_user", wxUserService.selectByOpenId(jsonObject.get("openid").toString()));
            }
        }
        return "";
    }

    @RequestMapping(value = "getQcode", method = RequestMethod.POST)
    public QrCode getQcode(Integer qr_id) {
        QrCode qrCode = qrCodeService.selectByid(qr_id);

        return qrCode;
    }

    @RequestMapping(value = "shareData", method = RequestMethod.POST)
    public Map<String, Object> shareData(String targetURL, HttpSession session) {
        Map<String, Object> stringMap = Constant.getConfig(targetURL);
        WxUser wxUser = (WxUser) session.getAttribute("wx_user");
        QrCode qrCode = qrCodeService.updateQrcode(wxUser.getId());
        Map<String, String> appMessage = new HashMap<String, String>();
        appMessage.put("title", "点击发福利了");
        appMessage.put("desc", "帮你的朋友成为土豪");
        appMessage.put("link", "http://irn9uu1.hn3.mofasuidao.cn/bbb/sweep_code.html?qr_id=" + qrCode.getId());
        appMessage.put("imgUrl", "http://irn9uu1.hn3.mofasuidao.cn/bbb/images/del-pic.jpg");
        Map<String, String> timeLine = new HashMap<String, String>();
        timeLine.put("title", "");
        timeLine.put("link", "http://irn9uu1.hn3.mofasuidao.cn/bbb/sweep_code.html?qr_id=" + qrCode.getId());
        timeLine.put("imgUrl", "http://irn9uu1.hn3.mofasuidao.cn/bbb/images/0928.jpg");
        stringMap.put("appMessage", appMessage);
        stringMap.put("timeLine", timeLine);
        return stringMap;
    }
    /*@RequestMapping(value = "index", method = RequestMethod.POST)
    public String indexToken(HttpServletRequest request) {
        MessageManagement messageManagement=new MessageManagement();
        String xml="";
        try {
            //1、jdom中创建SAXBuilder对象、调用当前对象的无参构造方法build()、读取request.getInputStream()接收的xml格式的字符串
            //2、此时读取的内容是文档Document、之后获取文档的根节点保存到  Element root 中
            Element root = new SAXBuilder().build(request.getInputStream()).getRootElement();
            String toUserName = root.getChildText("ToUserName");//依据root.getChildText（"ToUserName"）获取当前微信开发者的微信号
            String fromUserName = root.getChildText("FromUserName");//依据root.getChildText（"FromUserName"）获取当前用户的openid
            String createTime = root.getChildText("CreateTime");//依据root.getChildText（"CreateTime"）获取当前第时间
            String msgType = root.getChildText("MsgType");//依据root.getChildText（"MsgType"）获取当前的消息类型
            String event = root.getChildText("Event");//依据root.getChildText（"Event"）获取当前事件的类型包括（0(否)、1（是））
            WxUser wxUser1 = wxUserService.selectByOpenId(fromUserName);
            if (msgType.equals("event")) {
                System.out.println("进入事件消息");
                xml=messageManagement.managementMsg(msgType,event,wxUser1,fromUserName,toUserName);
            } else if (msgType.equals("image")) {
                System.out.println("进入图片消息");
            } else if (msgType.equals("text")) {
                System.out.println("进入文本消息");
                xml=messageManagement.managementMsg(msgType,event,wxUser1,fromUserName,toUserName);
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
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
        return xml;
    }*/
}
