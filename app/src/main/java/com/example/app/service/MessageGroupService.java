package com.example.app.service;

import com.example.app.model.MessageGroup;
public interface MessageGroupService{


    int deleteByPrimaryKey(Integer id);

    int insert(MessageGroup record);

    int insertSelective(MessageGroup record);

    MessageGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageGroup record);

    int updateByPrimaryKey(MessageGroup record);

}
