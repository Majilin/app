package com.example.app.mapper;

import com.example.app.model.Commodityspecification;

public interface CommodityspecificationMapper {
    int deleteByPrimaryKey(Integer psid);

    int insert(Commodityspecification record);

    int insertSelective(Commodityspecification record);

    Commodityspecification selectByPrimaryKey(Integer psid);

    int updateByPrimaryKeySelective(Commodityspecification record);

    int updateByPrimaryKey(Commodityspecification record);
}