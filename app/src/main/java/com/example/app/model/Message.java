package com.example.app.model;

import javax.persistence.Id;

public class Message {
    @Id
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 描述
    */
    private String description;

    /**
    * 图片路径
    */
    private String picurl;

    /**
    * 跳转路径
    */
    private String url;

    /**
    * 状态：-1禁用；0启用
    */
    private String status;

    /**
    * 当前消息
    */
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}