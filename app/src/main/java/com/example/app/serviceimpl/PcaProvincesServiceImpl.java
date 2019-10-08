package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.PcaProvincesMapper;
import com.example.app.model.PcaProvinces;
import com.example.app.service.PcaProvincesService;
@Service
public class PcaProvincesServiceImpl implements PcaProvincesService{

    @Resource
    private PcaProvincesMapper pcaProvincesMapper;

    @Override
    public int deleteByPrimaryKey(String provinceId) {
        return pcaProvincesMapper.deleteByPrimaryKey(provinceId);
    }

    @Override
    public int insert(PcaProvinces record) {
        return pcaProvincesMapper.insert(record);
    }

    @Override
    public int insertSelective(PcaProvinces record) {
        return pcaProvincesMapper.insertSelective(record);
    }

    @Override
    public PcaProvinces selectByPrimaryKey(String provinceId) {
        return pcaProvincesMapper.selectByPrimaryKey(provinceId);
    }

    @Override
    public int updateByPrimaryKeySelective(PcaProvinces record) {
        return pcaProvincesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PcaProvinces record) {
        return pcaProvincesMapper.updateByPrimaryKey(record);
    }

}
