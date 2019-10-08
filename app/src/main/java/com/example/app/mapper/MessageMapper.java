package com.example.app.mapper;

import com.example.app.model.Message;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    List<Message> selectMessagePush(String group);
}