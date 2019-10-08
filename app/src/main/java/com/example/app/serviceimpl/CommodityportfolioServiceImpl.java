package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.CommodityportfolioMapper;
import com.example.app.model.Commodityportfolio;
import com.example.app.service.CommodityportfolioService;
@Service
public class CommodityportfolioServiceImpl implements CommodityportfolioService{

    @Resource
    private CommodityportfolioMapper commodityportfolioMapper;

    @Override
    public int deleteByPrimaryKey(Integer cpid) {
        return commodityportfolioMapper.deleteByPrimaryKey(cpid);
    }

    @Override
    public int insert(Commodityportfolio record) {
        return commodityportfolioMapper.insert(record);
    }

    @Override
    public int insertSelective(Commodityportfolio record) {
        return commodityportfolioMapper.insertSelective(record);
    }

    @Override
    public Commodityportfolio selectByPrimaryKey(Integer cpid) {
        return commodityportfolioMapper.selectByPrimaryKey(cpid);
    }

    @Override
    public int updateByPrimaryKeySelective(Commodityportfolio record) {
        return commodityportfolioMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Commodityportfolio record) {
        return commodityportfolioMapper.updateByPrimaryKey(record);
    }

}
