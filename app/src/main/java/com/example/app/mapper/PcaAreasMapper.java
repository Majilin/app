package com.example.app.mapper;

import com.example.app.model.PcaAreas;

public interface PcaAreasMapper {
    int deleteByPrimaryKey(String areaId);

    int insert(PcaAreas record);

    int insertSelective(PcaAreas record);

    PcaAreas selectByPrimaryKey(String areaId);

    int updateByPrimaryKeySelective(PcaAreas record);

    int updateByPrimaryKey(PcaAreas record);
}