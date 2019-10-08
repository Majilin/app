package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Commodityspecification;
import com.example.app.mapper.CommodityspecificationMapper;
import com.example.app.service.CommodityspecificationService;
@Service
public class CommodityspecificationServiceImpl implements CommodityspecificationService{

    @Resource
    private CommodityspecificationMapper commodityspecificationMapper;

    @Override
    public int deleteByPrimaryKey(Integer psid) {
        return commodityspecificationMapper.deleteByPrimaryKey(psid);
    }

    @Override
    public int insert(Commodityspecification record) {
        return commodityspecificationMapper.insert(record);
    }

    @Override
    public int insertSelective(Commodityspecification record) {
        return commodityspecificationMapper.insertSelective(record);
    }

    @Override
    public Commodityspecification selectByPrimaryKey(Integer psid) {
        return commodityspecificationMapper.selectByPrimaryKey(psid);
    }

    @Override
    public int updateByPrimaryKeySelective(Commodityspecification record) {
        return commodityspecificationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Commodityspecification record) {
        return commodityspecificationMapper.updateByPrimaryKey(record);
    }

}
