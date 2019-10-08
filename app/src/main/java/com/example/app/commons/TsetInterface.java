package com.example.app.commons;

import org.json.JSONObject;

public class TsetInterface {
    public static void main(String[] args) {
        String  url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+Constant.getAcccess_token();
        String data="{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        JSONObject jsonObject = HttpClientUtil.doPost(url, data);
        System.out.println(jsonObject);

    }
}
