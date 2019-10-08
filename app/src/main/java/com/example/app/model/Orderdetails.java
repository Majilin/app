package com.example.app.model;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Orderdetails {
    /**
     * 订单详情id
     */
    @Id
    private String odetid;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品数量
     */
    private Integer amount;

    /**
     * 订单id
     */
    private String ordid;

    /**
     * 购买时单价
     */
    private Integer price;

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

    public String getOdetid() {
        return odetid;
    }

    public void setOdetid(String odetid) {
        this.odetid = odetid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}