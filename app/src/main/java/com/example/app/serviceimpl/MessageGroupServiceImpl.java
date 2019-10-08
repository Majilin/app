package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.MessageGroup;
import com.example.app.mapper.MessageGroupMapper;
import com.example.app.service.MessageGroupService;
@Service
public class MessageGroupServiceImpl implements MessageGroupService{

    @Resource
    private MessageGroupMapper messageGroupMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return messageGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MessageGroup record) {
        return messageGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(MessageGroup record) {
        return messageGroupMapper.insertSelective(record);
    }

    @Override
    public MessageGroup selectByPrimaryKey(Integer id) {
        return messageGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MessageGroup record) {
        return messageGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MessageGroup record) {
        return messageGroupMapper.updateByPrimaryKey(record);
    }

}
