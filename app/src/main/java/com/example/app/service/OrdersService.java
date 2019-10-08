package com.example.app.service;

import com.example.app.model.Orders;

import java.util.List;

public interface OrdersService{

    List<Orders> getOrders(Integer userid);

    List<Orders> getOrderByStatus(Integer userid, Integer ordStatus);

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

}
