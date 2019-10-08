package com.example.app.service;

import com.example.app.model.Sharetable;
public interface SharetableService{


    int deleteByPrimaryKey(Integer id);

    int insert(Sharetable record);

    int insertSelective(Sharetable record);

    Sharetable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sharetable record);

    int updateByPrimaryKey(Sharetable record);

}
