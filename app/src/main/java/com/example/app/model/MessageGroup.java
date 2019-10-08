package com.example.app.model;

import javax.persistence.Id;

public class MessageGroup {
    @Id
    private Integer id;

    private Integer mId;

    /**
    * -1禁用；0启用
    */
    private String status;

    /**
    * 0关注被动推送；1主动推送
    */
    private String group;

    /**
    * 排序
    */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}