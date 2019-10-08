package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.CommodityspecificationvalueMapper;
import com.example.app.model.Commodityspecificationvalue;
import com.example.app.service.CommodityspecificationvalueService;
@Service
public class CommodityspecificationvalueServiceImpl implements CommodityspecificationvalueService{

    @Resource
    private CommodityspecificationvalueMapper commodityspecificationvalueMapper;

    @Override
    public int deleteByPrimaryKey(Integer psvid) {
        return commodityspecificationvalueMapper.deleteByPrimaryKey(psvid);
    }

    @Override
    public int insert(Commodityspecificationvalue record) {
        return commodityspecificationvalueMapper.insert(record);
    }

    @Override
    public int insertSelective(Commodityspecificationvalue record) {
        return commodityspecificationvalueMapper.insertSelective(record);
    }

    @Override
    public Commodityspecificationvalue selectByPrimaryKey(Integer psvid) {
        return commodityspecificationvalueMapper.selectByPrimaryKey(psvid);
    }

    @Override
    public int updateByPrimaryKeySelective(Commodityspecificationvalue record) {
        return commodityspecificationvalueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Commodityspecificationvalue record) {
        return commodityspecificationvalueMapper.updateByPrimaryKey(record);
    }

}
