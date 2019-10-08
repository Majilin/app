package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Sharetable;
import com.example.app.mapper.SharetableMapper;
import com.example.app.service.SharetableService;
@Service
public class SharetableServiceImpl implements SharetableService{

    @Resource
    private SharetableMapper sharetableMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sharetableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sharetable record) {
        return sharetableMapper.insert(record);
    }

    @Override
    public int insertSelective(Sharetable record) {
        return sharetableMapper.insertSelective(record);
    }

    @Override
    public Sharetable selectByPrimaryKey(Integer id) {
        return sharetableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sharetable record) {
        return sharetableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sharetable record) {
        return sharetableMapper.updateByPrimaryKey(record);
    }

}
