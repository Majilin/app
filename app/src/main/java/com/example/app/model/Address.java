package com.example.app.model;

import javax.persistence.Transient;

public class Address {
    /**
     * 地址表id
     */
    private Integer aid;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 说活人电话
     */
    private String consigneetel;

    /**
     * 省id
     */
    private Integer provinceId;

    /**
     * 市id
     */
    private Integer cityId;

    /**
     * 区id
     */
    private Integer areaId;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 状态:0,非默认地址;1,默认地址;
     */
    private Integer addStatus;

    /**
     * userid
     */
    private Integer userid;
    @Transient
    private  PcaProvinces pcaProvinces;
    @Transient
    private  PcaCities pcaCities;
    @Transient
    private  PcaAreas pcaAreas;

    public PcaProvinces getPcaProvinces() {
        return pcaProvinces;
    }

    public void setPcaProvinces(PcaProvinces pcaProvinces) {
        this.pcaProvinces = pcaProvinces;
    }

    public PcaCities getPcaCities() {
        return pcaCities;
    }

    public void setPcaCities(PcaCities pcaCities) {
        this.pcaCities = pcaCities;
    }

    public PcaAreas getPcaAreas() {
        return pcaAreas;
    }

    public void setPcaAreas(PcaAreas pcaAreas) {
        this.pcaAreas = pcaAreas;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneetel() {
        return consigneetel;
    }

    public void setConsigneetel(String consigneetel) {
        this.consigneetel = consigneetel;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getAddStatus() {
        return addStatus;
    }

    public void setAddStatus(Integer addStatus) {
        this.addStatus = addStatus;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}