package com.example.app.service;

import com.example.app.model.Commodityspecification;
public interface CommodityspecificationService{


    int deleteByPrimaryKey(Integer psid);

    int insert(Commodityspecification record);

    int insertSelective(Commodityspecification record);

    Commodityspecification selectByPrimaryKey(Integer psid);

    int updateByPrimaryKeySelective(Commodityspecification record);

    int updateByPrimaryKey(Commodityspecification record);

}
