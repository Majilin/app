package com.example.app.commons;

import com.example.app.model.WeChatType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Constant {
    public static final String APPID = "wx5f1f19325eb3d811";
    public static final String APPSECERT = "5b64a6e36ee7f2c3e0c90776b4661e59";
    public static String ACCESS_TOKEN = null;
    public static long ACCESS_TOKEN_TIME = 0L;
    public static String JSAPI_TICKET = null;
    public static long JSAPI_TICKET_TIME = 0L;

    public static String getAcccess_token() {
        long now = System.currentTimeMillis() / 1000;
        if (ACCESS_TOKEN == null || (now - ACCESS_TOKEN_TIME) > 7200) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECERT;
            JSONObject jsonObject = HttpClientUtil.doGet(url);
            ACCESS_TOKEN_TIME = System.currentTimeMillis() / 1000;
            ACCESS_TOKEN = jsonObject.get("access_token").toString();
        }
        return ACCESS_TOKEN;
    }

    public static String getJSAPI_ticket() {
        long now = System.currentTimeMillis() / 1000;
        if (ACCESS_TOKEN == null || (now - JSAPI_TICKET_TIME) > 7200) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getAcccess_token() + "&type=jsapi";
            JSONObject jsonObject = HttpClientUtil.doGet(url);
            if (jsonObject.get("errcode").toString().equals("0")) {
                JSAPI_TICKET_TIME = System.currentTimeMillis() / 1000;
                JSAPI_TICKET = jsonObject.get("ticket").toString();
            }
        }
        return JSAPI_TICKET;
    }
    public static Map<String, Object> getConfig(String targetURL) {
        String jsapi_ticket = getJSAPI_ticket();
        String nonceStr = UUID.randomUUID().toString().replaceAll("-", "");
        long timestamp = System.currentTimeMillis() / 1000;
        String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + targetURL;
        String signature = WeChatType.getSha1(str);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appId",APPID );
        map.put("timestamp",String.valueOf(timestamp));
        map.put("nonceStr",nonceStr );
        map.put("signature",signature );
        return map;
    }
}
