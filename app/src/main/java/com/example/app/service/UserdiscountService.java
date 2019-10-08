package com.example.app.service;

import com.example.app.model.Userdiscount;
public interface UserdiscountService{


    int deleteByPrimaryKey(Integer id);

    int insert(Userdiscount record);

    int insertSelective(Userdiscount record);

    Userdiscount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userdiscount record);

    int updateByPrimaryKey(Userdiscount record);

}
