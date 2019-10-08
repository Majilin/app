package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.PcaAreasMapper;
import com.example.app.model.PcaAreas;
import com.example.app.service.PcaAreasService;
@Service
public class PcaAreasServiceImpl implements PcaAreasService{

    @Resource
    private PcaAreasMapper pcaAreasMapper;

    @Override
    public int deleteByPrimaryKey(String areaId) {
        return pcaAreasMapper.deleteByPrimaryKey(areaId);
    }

    @Override
    public int insert(PcaAreas record) {
        return pcaAreasMapper.insert(record);
    }

    @Override
    public int insertSelective(PcaAreas record) {
        return pcaAreasMapper.insertSelective(record);
    }

    @Override
    public PcaAreas selectByPrimaryKey(String areaId) {
        return pcaAreasMapper.selectByPrimaryKey(areaId);
    }

    @Override
    public int updateByPrimaryKeySelective(PcaAreas record) {
        return pcaAreasMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PcaAreas record) {
        return pcaAreasMapper.updateByPrimaryKey(record);
    }

}
