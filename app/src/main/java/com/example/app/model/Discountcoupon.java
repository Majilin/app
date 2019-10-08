package com.example.app.model;

import java.util.Date;

public class Discountcoupon {
    /**
    * 优惠券id
    */
    private Integer dcid;

    /**
    * 优惠券标题
    */
    private String title;

    /**
    * 开始时间
    */
    private Date starttime;

    /**
    * 截至时间
    */
    private Date endtime;

    /**
    * 优惠价格
    */
    private Integer discountprice;

    /**
    * 所需积分
    */
    private Integer integral;

    /**
    * 优惠券状态，0启用，1不可用
    */
    private Integer dcStatus;

    public Integer getDcid() {
        return dcid;
    }

    public void setDcid(Integer dcid) {
        this.dcid = dcid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Integer discountprice) {
        this.discountprice = discountprice;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getDcStatus() {
        return dcStatus;
    }

    public void setDcStatus(Integer dcStatus) {
        this.dcStatus = dcStatus;
    }
}