package com.example.app.mapper;

import com.example.app.model.Repertory;

public interface RepertoryMapper {
    int deleteByPrimaryKey(Integer skuid);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    Repertory selectByPrimaryKey(Integer skuid);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);
}