package com.example.app.model;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeChatType {
    private String signature;//微信加密签名
    private String timestamp;//时间戳
    private String nonce ;//随机数
    private String  echostr;//随机字符串
    private final String  token="16";//自定义token数据

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
    /*
    * 依据时间戳和随机数以及token三个参数按照字典序排序
    * */
    public boolean checkinfo(){
        String str="";
        List<String> list =new ArrayList<String>();//创建List集合接收时间戳和随机数以及token
        list.add(timestamp);//时间戳
        list.add(nonce);//随机数
        list.add(token);//token
        Collections.sort(list);//Collection集合升序(字典序)排序List集合
        for (String s : list) {
            str+=s;//遍历List集合追加成字符串
        }
        String sha1Str= getSha1(str);//调用sha1加密算法返回依据时间戳和随机数以及token组成的字符串
        System.out.println(sha1Str);
        System.out.println(signature);
        if(signature.equals(sha1Str)){//比较sha1机密算法产生的字符串与微信加密签名signature是否相等
            return true;
        }
        return false;
    }
    public static String getSha1(String str) {

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");//加密类型
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public String toString() {
        return "WeChatType{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", echostr='" + echostr + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
