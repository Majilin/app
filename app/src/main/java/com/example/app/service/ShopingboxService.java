package com.example.app.service;

import com.example.app.model.Shopingbox;

import java.util.List;

public interface ShopingboxService{
    List<Shopingbox> getshopcarlist(Integer userid);

    Shopingbox getshopcarBySid(Integer sid,Integer userid);

    int deleteByPrimaryKey(Integer sid);

    int insert(Shopingbox record);

    int insertSelective(Shopingbox record);

    Shopingbox selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Shopingbox record);

    int updateByPrimaryKey(Shopingbox record);

}
