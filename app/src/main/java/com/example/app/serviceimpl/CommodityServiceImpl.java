package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.CommodityMapper;
import com.example.app.model.Commodity;
import com.example.app.service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService{

    @Resource
    private CommodityMapper commodityMapper;


    @Override
    public Commodity selectByPrimaryKey(Integer spuid) {
        return null;
    }

    @Override
    public List<Commodity> selectByActice() {
        return commodityMapper.selectByActice();
    }

    @Override
    public List<Commodity> selectByamount() {
        return commodityMapper.selectByamount();
    }

    @Override
    public List<Commodity> selectorderByamount() {
        return commodityMapper.selectorderByamount();
    }


}
