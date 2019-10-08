package com.example.app.model;

import java.util.Date;

public class Commodityspecificationvalue {
    /**
    * 规格值id
    */
    private Integer psvid;

    /**
    * 商品id
    */
    private Integer spuid;

    /**
    * 规格id
    */
    private Integer psid;

    /**
    * 创建时间
    */
    private Date psvCretime;

    /**
    * 修改时间
    */
    private Date psvEditime;

    /**
    * 规格值状态
    */
    private Integer psvStatus;

    /**
    * 规格值
    */
    private String psvalue;

    public Integer getPsvid() {
        return psvid;
    }

    public void setPsvid(Integer psvid) {
        this.psvid = psvid;
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

    public Date getPsvCretime() {
        return psvCretime;
    }

    public void setPsvCretime(Date psvCretime) {
        this.psvCretime = psvCretime;
    }

    public Date getPsvEditime() {
        return psvEditime;
    }

    public void setPsvEditime(Date psvEditime) {
        this.psvEditime = psvEditime;
    }

    public Integer getPsvStatus() {
        return psvStatus;
    }

    public void setPsvStatus(Integer psvStatus) {
        this.psvStatus = psvStatus;
    }

    public String getPsvalue() {
        return psvalue;
    }

    public void setPsvalue(String psvalue) {
        this.psvalue = psvalue;
    }
}