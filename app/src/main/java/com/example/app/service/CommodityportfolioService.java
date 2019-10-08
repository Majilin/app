package com.example.app.service;

import com.example.app.model.Commodityportfolio;
public interface CommodityportfolioService{


    int deleteByPrimaryKey(Integer cpid);

    int insert(Commodityportfolio record);

    int insertSelective(Commodityportfolio record);

    Commodityportfolio selectByPrimaryKey(Integer cpid);

    int updateByPrimaryKeySelective(Commodityportfolio record);

    int updateByPrimaryKey(Commodityportfolio record);

}
