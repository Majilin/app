package com.example.app.service;

import com.example.app.commons.MyJsonBean;
import com.example.app.model.Address;
public interface AddressService{
    //获取地址信息
    MyJsonBean getAlladdress(Integer userid);

    Address getaddress(Integer aid,Integer userid);

    int deleteByPrimaryKey(Integer aid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);


}
