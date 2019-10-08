package com.example.app.service;

import com.example.app.model.Orderdetails;
public interface OrderdetailsService{


    int deleteByPrimaryKey(Integer odetid);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    Orderdetails selectByPrimaryKey(Integer odetid);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);

}
