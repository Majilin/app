package com.example.app.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpClientTest {
    public static JSONObject access_token() {
        String appid = "wx5f1f19325eb3d811";//微信登录时产生的appid
        String appsecret = "5b64a6e36ee7f2c3e0c90776b4661e59";//微信登录时产生的appsecret
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
        JSONObject jsonObject = HttpClientUtil.doGet(url);
        //jsonObjectAccessToken.get("access_token")获取access_token的值
        return jsonObject;
    }

    public static void main(String[] args) {
        JSONObject jsonObjectAccessToken = access_token();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + jsonObjectAccessToken.get("access_token");
        JSONObject big = new JSONObject();
        JSONArray button = new JSONArray();
        JSONObject menua = new JSONObject();
        menua.put("name", "首页");
        menua.put("type", "view");
        try {
            menua.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constant.APPID + "&redirect_uri=" + URLEncoder.encode("http://irn9uu1.hn3.mofasuidao.cn/bbb/index.html", "utf-8") + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        JSONObject menub = new JSONObject();
        menub.put("name", "购物车");
        menub.put("type", "view");
        try {
            menub.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constant.APPID + "&redirect_uri=" + URLEncoder.encode("http://irn9uu1.hn3.mofasuidao.cn/bbb/shopcar.html", "utf-8") + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject menuc = new JSONObject();
        menuc.put("name", "个人中心");
        menuc.put("type", "view");
        try {
            menuc.put("url", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + Constant.APPID + "&redirect_uri=" + URLEncoder.encode("http://irn9uu1.hn3.mofasuidao.cn/bbb/pcenter.html", "utf-8") + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        button.put(menua);
        button.put(menub);
        button.put(menuc);
        big.put("button", button);
        JSONObject jsonObject = HttpClientUtil.doPost(url, big.toString());
        System.out.println(jsonObject);
    }
}
