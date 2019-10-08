package com.example.app.model;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

public class Commodity {
    /**
     * 表id
     */
    @Id
    private Integer spuid;

    /**
     * 产品名称
     */
    private String pname;

    /**
     * 品牌id
     */
    private Integer bid;

    /**
     * 二级类目id
     */
    private Integer scid;

    /**
     * 展示图片
     */
    private String pImg;

    /**
     * 创建时间
     */
    private Date createtime;

    private List<Repertory> repertory;

    public List<Repertory> getRepertory() {
        return repertory;
    }

    public void setRepertory(List<Repertory> repertory) {
        this.repertory = repertory;
    }
    /*@Transient
    private Repertory repertory;

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }*/

    /**
     * 0:下架；1:正常；2:促销
     */
    private Integer prodStatus;

    /**
     * 修改时间
     */
    private Date changetime;

    public Integer getSpuid() {
        return spuid;
    }

    public void setSpuid(Integer spuid) {
        this.spuid = spuid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(Integer prodStatus) {
        this.prodStatus = prodStatus;
    }

    public Date getChangetime() {
        return changetime;
    }

    public void setChangetime(Date changetime) {
        this.changetime = changetime;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "spuid=" + spuid +
                ", pname='" + pname + '\'' +
                ", bid=" + bid +
                ", scid=" + scid +
                ", pImg='" + pImg + '\'' +
                ", createtime=" + createtime +
                ", repertory=" + repertory +
                ", prodStatus=" + prodStatus +
                ", changetime=" + changetime +
                '}';
    }
}