package com.example.app.mapper;

import com.example.app.model.Sharetable;

public interface SharetableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sharetable record);

    int insertSelective(Sharetable record);

    Sharetable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sharetable record);

    int updateByPrimaryKey(Sharetable record);
}