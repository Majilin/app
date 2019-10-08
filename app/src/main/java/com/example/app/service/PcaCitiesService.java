package com.example.app.service;

import com.example.app.model.PcaCities;
public interface PcaCitiesService{


    int deleteByPrimaryKey(String cityId);

    int insert(PcaCities record);

    int insertSelective(PcaCities record);

    PcaCities selectByPrimaryKey(String cityId);

    int updateByPrimaryKeySelective(PcaCities record);

    int updateByPrimaryKey(PcaCities record);

}
