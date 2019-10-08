package com.example.app.mapper;

import com.example.app.model.Orderdetails;

public interface OrderdetailsMapper {
    int deleteByPrimaryKey(Integer odetid);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    Orderdetails selectByPrimaryKey(Integer odetid);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);
}