package com.example.app.service;

import com.example.app.model.Commodityspecificationvalue;
public interface CommodityspecificationvalueService{


    int deleteByPrimaryKey(Integer psvid);

    int insert(Commodityspecificationvalue record);

    int insertSelective(Commodityspecificationvalue record);

    Commodityspecificationvalue selectByPrimaryKey(Integer psvid);

    int updateByPrimaryKeySelective(Commodityspecificationvalue record);

    int updateByPrimaryKey(Commodityspecificationvalue record);

}
