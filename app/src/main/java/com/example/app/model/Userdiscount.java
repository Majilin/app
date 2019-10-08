package com.example.app.model;

public class Userdiscount {
    /**
    * 用户优惠券id
    */
    private Integer id;

    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 优惠券id
    */
    private Integer dcid;

    /**
    * 状态
    */
    private Integer udcStatus;

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

    public Integer getDcid() {
        return dcid;
    }

    public void setDcid(Integer dcid) {
        this.dcid = dcid;
    }

    public Integer getUdcStatus() {
        return udcStatus;
    }

    public void setUdcStatus(Integer udcStatus) {
        this.udcStatus = udcStatus;
    }
}