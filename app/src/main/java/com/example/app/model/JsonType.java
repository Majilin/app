package com.example.app.model;

public class JsonType {
    private Object object;
    private String code;
    private String msg;

    public JsonType() {
    }

    public JsonType( String code,Object object, String msg) {
        this.object = object;
        this.code = code;
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
