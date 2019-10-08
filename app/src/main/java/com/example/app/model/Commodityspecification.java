package com.example.app.model;

import java.util.Date;

public class Commodityspecification {
    /**
    * 商品规格id
    */
    private Integer psid;

    /**
    * 规格名字
    */
    private String psname;

    /**
    * 二级类目id
    */
    private Integer scid;

    /**
    * 商品id
    */
    private Integer spuid;

    /**
    * 创建时间
    */
    private Date psCretime;

    /**
    * 修改时间
    */
    private Date psEditime;

    public Integer getPsid() {
        return psid;
    }

    public void setPsid(Integer psid) {
        this.psid = psid;
    }

    public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getSpuid() {
        return spuid;
    }

    public void setSpuid(Integer spuid) {
        this.spuid = spuid;
    }

    public Date getPsCretime() {
        return psCretime;
    }

    public void setPsCretime(Date psCretime) {
        this.psCretime = psCretime;
    }

    public Date getPsEditime() {
        return psEditime;
    }

    public void setPsEditime(Date psEditime) {
        this.psEditime = psEditime;
    }
}