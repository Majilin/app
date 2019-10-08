package com.example.app.mapper;

import com.example.app.model.PcaProvinces;

public interface PcaProvincesMapper {
    int deleteByPrimaryKey(String provinceId);

    int insert(PcaProvinces record);

    int insertSelective(PcaProvinces record);

    PcaProvinces selectByPrimaryKey(String provinceId);

    int updateByPrimaryKeySelective(PcaProvinces record);

    int updateByPrimaryKey(PcaProvinces record);
}