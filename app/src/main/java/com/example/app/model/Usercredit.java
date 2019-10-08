package com.example.app.model;

public class Usercredit {
    /**
    * 用户积分表
    */
    private Integer ucid;

    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 积分
    */
    private Integer integral;

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}