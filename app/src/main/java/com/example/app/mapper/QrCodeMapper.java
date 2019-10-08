package com.example.app.mapper;

import com.example.app.model.QrCode;

public interface QrCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrCode record);

    int insertSelective(QrCode record);

    QrCode selectByPrimaryKey(Integer wx_id);
    QrCode selectByid(Integer id);

    int updateByPrimaryKeySelective(QrCode record);

    int updateByPrimaryKey(QrCode record);
}