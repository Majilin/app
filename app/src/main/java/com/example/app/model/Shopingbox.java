package com.example.app.model;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Shopingbox {
    /**
     * 购物车表id
     */
    @Id
    private Integer sid;

    /**
     * 商品组合表id
     */
    private Integer cpid;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 用户id
     */
    private Integer uid;
    @Transient
    private Commodity commodity;
    @Transient
    private Commodityportfolio commodityportfolio;
    @Transient
    private Commodityspecification commodityspecification;
    @Transient
    private Commodityspecificationvalue commodityspecificationvalue;
    @Transient
    private Repertory repertory;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Commodityportfolio getCommodityportfolio() {
        return commodityportfolio;
    }

    public void setCommodityportfolio(Commodityportfolio commodityportfolio) {
        this.commodityportfolio = commodityportfolio;
    }

    public Commodityspecification getCommodityspecification() {
        return commodityspecification;
    }

    public void setCommodityspecification(Commodityspecification commodityspecification) {
        this.commodityspecification = commodityspecification;
    }

    public Commodityspecificationvalue getCommodityspecificationvalue() {
        return commodityspecificationvalue;
    }

    public void setCommodityspecificationvalue(Commodityspecificationvalue commodityspecificationvalue) {
        this.commodityspecificationvalue = commodityspecificationvalue;
    }

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}