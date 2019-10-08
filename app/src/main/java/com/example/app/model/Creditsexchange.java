package com.example.app.model;

public class Creditsexchange {
    /**
    * 积分兑换id
    */
    private Integer ceid;

    /**
    * 库存id
    */
    private Integer skuid;

    /**
    * 所需积分
    */
    private Integer integral;

    public Integer getCeid() {
        return ceid;
    }

    public void setCeid(Integer ceid) {
        this.ceid = ceid;
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}