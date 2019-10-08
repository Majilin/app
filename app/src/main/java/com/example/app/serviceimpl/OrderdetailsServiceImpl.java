package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Orderdetails;
import com.example.app.mapper.OrderdetailsMapper;
import com.example.app.service.OrderdetailsService;
@Service
public class OrderdetailsServiceImpl implements OrderdetailsService{

    @Resource
    private OrderdetailsMapper orderdetailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer odetid) {
        return orderdetailsMapper.deleteByPrimaryKey(odetid);
    }

    @Override
    public int insert(Orderdetails record) {
        return orderdetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(Orderdetails record) {
        return orderdetailsMapper.insertSelective(record);
    }

    @Override
    public Orderdetails selectByPrimaryKey(Integer odetid) {
        return orderdetailsMapper.selectByPrimaryKey(odetid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetails record) {
        return orderdetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderdetails record) {
        return orderdetailsMapper.updateByPrimaryKey(record);
    }

}
