package com.example.app.model;

import java.util.Date;

public class Signin {
    /**
    * 签到表id
    */
    private Integer id;

    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 连续签到天数
    */
    private Integer day;

    /**
    * 上次签到天数
    */
    private Date lasttime;

    /**
    * 状态，0代表连续中，1代表断开
    */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}