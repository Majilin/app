package com.example.app.mapper;

import com.example.app.model.Commodityportfolio;

public interface CommodityportfolioMapper {
    int deleteByPrimaryKey(Integer cpid);

    int insert(Commodityportfolio record);

    int insertSelective(Commodityportfolio record);

    Commodityportfolio selectByPrimaryKey(Integer cpid);

    int updateByPrimaryKeySelective(Commodityportfolio record);

    int updateByPrimaryKey(Commodityportfolio record);
}