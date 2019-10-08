package com.example.app.mapper;

import com.example.app.model.Commodityspecificationvalue;

public interface CommodityspecificationvalueMapper {
    int deleteByPrimaryKey(Integer psvid);

    int insert(Commodityspecificationvalue record);

    int insertSelective(Commodityspecificationvalue record);

    Commodityspecificationvalue selectByPrimaryKey(Integer psvid);

    int updateByPrimaryKeySelective(Commodityspecificationvalue record);

    int updateByPrimaryKey(Commodityspecificationvalue record);
}