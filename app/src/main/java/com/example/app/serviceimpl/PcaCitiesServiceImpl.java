package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.PcaCitiesMapper;
import com.example.app.model.PcaCities;
import com.example.app.service.PcaCitiesService;
@Service
public class PcaCitiesServiceImpl implements PcaCitiesService{

    @Resource
    private PcaCitiesMapper pcaCitiesMapper;

    @Override
    public int deleteByPrimaryKey(String cityId) {
        return pcaCitiesMapper.deleteByPrimaryKey(cityId);
    }

    @Override
    public int insert(PcaCities record) {
        return pcaCitiesMapper.insert(record);
    }

    @Override
    public int insertSelective(PcaCities record) {
        return pcaCitiesMapper.insertSelective(record);
    }

    @Override
    public PcaCities selectByPrimaryKey(String cityId) {
        return pcaCitiesMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public int updateByPrimaryKeySelective(PcaCities record) {
        return pcaCitiesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PcaCities record) {
        return pcaCitiesMapper.updateByPrimaryKey(record);
    }

}
