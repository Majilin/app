package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Repertory;
import com.example.app.mapper.RepertoryMapper;
import com.example.app.service.RepertoryService;
@Service
public class RepertoryServiceImpl implements RepertoryService{

    @Resource
    private RepertoryMapper repertoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer skuid) {
        return repertoryMapper.deleteByPrimaryKey(skuid);
    }

    @Override
    public int insert(Repertory record) {
        return repertoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Repertory record) {
        return repertoryMapper.insertSelective(record);
    }

    @Override
    public Repertory selectByPrimaryKey(Integer skuid) {
        return repertoryMapper.selectByPrimaryKey(skuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Repertory record) {
        return repertoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Repertory record) {
        return repertoryMapper.updateByPrimaryKey(record);
    }

}
