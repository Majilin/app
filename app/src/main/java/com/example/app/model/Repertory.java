package com.example.app.model;

import javax.persistence.Id;

public class Repertory {
    /**
    * skuid
    */

    private Integer skuid;

    /**
    * 商品表spuid
    */
    private Integer spuid;

    /**
    * 商品组合表
    */
    private Integer cpid;

    /**
    * 颜色
    */
    private String color;

    /**
    * 数量
    */
    private Integer amount;

    /**
    * 进货价
    */
    private Integer chargeprice;

    /**
    * 销售原价
    */
    private Integer salesprice;

    /**
    * 活动价
    */
    private Integer activeprice;

    /**
    * 状态
    */
    private Integer skuStatus;

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Integer getSpuid() {
        return spuid;
    }

    public void setSpuid(Integer spuid) {
        this.spuid = spuid;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getChargeprice() {
        return chargeprice;
    }

    public void setChargeprice(Integer chargeprice) {
        this.chargeprice = chargeprice;
    }

    public Integer getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Integer salesprice) {
        this.salesprice = salesprice;
    }

    public Integer getActiveprice() {
        return activeprice;
    }

    public void setActiveprice(Integer activeprice) {
        this.activeprice = activeprice;
    }

    public Integer getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }
}