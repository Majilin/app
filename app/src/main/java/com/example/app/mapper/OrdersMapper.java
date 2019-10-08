package com.example.app.mapper;

import com.example.app.model.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    List<Orders> getOrders(Integer userid);

    List<Orders> getOrderByStatus(@Param("userid") Integer userid, @Param("ordStatus")Integer ordStatus);
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}