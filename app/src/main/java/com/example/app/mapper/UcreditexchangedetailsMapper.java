package com.example.app.mapper;

import com.example.app.model.Ucreditexchangedetails;

import java.util.List;
import java.util.Map;

public interface UcreditexchangedetailsMapper {
    /**
     * 根据用户id查询该用户已兑换的商品
     * @return
     */
    List<Map<String,Object>> selectAllExchangeByuid(int uid);

    int deleteByPrimaryKey(Integer ucedid);

    int insert(Ucreditexchangedetails record);

    int insertSelective(Ucreditexchangedetails record);

    Ucreditexchangedetails selectByPrimaryKey(Integer ucedid);

    int updateByPrimaryKeySelective(Ucreditexchangedetails record);

    int updateByPrimaryKey(Ucreditexchangedetails record);
}