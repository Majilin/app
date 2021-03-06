package com.example.app.model;

import java.util.List;

public class Orders {
    /**
     * 订单号
     */
    private String id;

    /**
     * 时间
     */
    private String ordertime;

    /**
     * 总价
     */
    private Integer totalprice;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 地址id
     */
    private Integer addressid;

    /**
     * 订单状态：0,待支付;1,待发货;2,待收货;3,待评价;4,已完成;
     */
    private Integer ordStatus;

    private List<Orderdetails> orderdetailsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Integer ordStatus) {
        this.ordStatus = ordStatus;
    }

    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }
}
