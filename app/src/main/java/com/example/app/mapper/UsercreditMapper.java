package com.example.app.mapper;

import com.example.app.model.Usercredit;

public interface UsercreditMapper {
    int deleteByPrimaryKey(Integer ucid);

    int insert(Usercredit record);

    int insertSelective(Usercredit record);

    Usercredit selectByPrimaryKey(Integer ucid);

    int updateByPrimaryKeySelective(Usercredit record);

    int updateByPrimaryKey(Usercredit record);
}