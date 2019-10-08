package com.example.app.mapper;

import com.example.app.model.Userdiscount;

public interface UserdiscountMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Userdiscount record);

    int insertSelective(Userdiscount record);

    Userdiscount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userdiscount record);

    int updateByPrimaryKey(Userdiscount record);
}