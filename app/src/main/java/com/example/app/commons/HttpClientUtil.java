package com.example.app.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClientUtil {
    public static JSONObject doGet(String url) {
        JSONObject jsonObject = null;
        HttpGet httpGet = new HttpGet(url);//创建HttpGet请求
        HttpClient httpClient = new DefaultHttpClient();//创建客户顿
        jsonObject = getJsonObject(jsonObject, httpGet, httpClient);//调用getJsonObject（）方法
        return jsonObject;
    }

    public static JSONObject doPost(String url, String data) {
        JSONObject jsonObject = null;
        HttpPost httpPost = new HttpPost(url);//创建httpPost请求
        HttpClient httpClient = new DefaultHttpClient();//创建客户端
        httpPost.setEntity(new StringEntity(data, "utf-8"));//往httppost传值并设置字符集格式为UTF-8
        jsonObject = getJsonObject(jsonObject, httpPost, httpClient);//抽离方法
        return jsonObject;
    }

    private static JSONObject getJsonObject(JSONObject jsonObject, HttpRequestBase httpRequestBase, HttpClient httpClient) {
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequestBase);//执行请求路径
            String str = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");//接收请求的返回的结果
            jsonObject = new JSONObject(str);//加入json依赖   此依赖是把字符串转化为json格式
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
