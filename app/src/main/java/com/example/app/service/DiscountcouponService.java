package com.example.app.service;

import com.example.app.model.Discountcoupon;

import java.util.List;
import java.util.Map;

public interface DiscountcouponService{


    //查询所有优惠券
    List<Map<String,Object>> selectAllCoupon();


    int deleteByPrimaryKey(Integer dcid);

    int insert(Discountcoupon record);

    int insertSelective(Discountcoupon record);

    Discountcoupon selectByPrimaryKey(Integer dcid);

    int updateByPrimaryKeySelective(Discountcoupon record);

    int updateByPrimaryKey(Discountcoupon record);


}
