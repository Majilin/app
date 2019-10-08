package com.example.app.model;

import java.util.Date;

public class Commodityportfolio {
    /**
    * 商品组合表
    */
    private Integer cpid;

    /**
    * 商品表id
    */
    private Integer spuid;

    /**
    * 商品规格id
    */
    private Integer psid;

    /**
    * 商品规格值id
    */
    private Integer psvid;

    /**
    * 库存id
    */
    private Integer skuid;

    /**
    * 创建时间
    */
    private Date cpCretime;

    /**
    * 修改时间
    */
    private Date cpEditime;

    /**
    * 状态
    */
    private Integer cpStatus;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getSpuid() {
        return spuid;
    }

    public void setSpuid(Integer spuid) {
        this.spuid = spuid;
    }

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    public Integer getPsvid() {
        return psvid;
    }

    public void setPsvid(Integer psvid) {
        this.psvid = psvid;
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Date getCpCretime() {
        return cpCretime;
    }

    public void setCpCretime(Date cpCretime) {
        this.cpCretime = cpCretime;
    }

    public Date getCpEditime() {
        return cpEditime;
    }

    public void setCpEditime(Date cpEditime) {
        this.cpEditime = cpEditime;
    }

    public Integer getCpStatus() {
        return cpStatus;
    }

    public void setCpStatus(Integer cpStatus) {
        this.cpStatus = cpStatus;
    }
}