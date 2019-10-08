package com.example.app.service;

import com.example.app.model.Repertory;
public interface RepertoryService{


    int deleteByPrimaryKey(Integer skuid);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    Repertory selectByPrimaryKey(Integer skuid);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);

}
