package com.example.app.service;

import com.example.app.model.WxUser;
public interface WxUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
    WxUser selectByOpenId(String  openid);

}
