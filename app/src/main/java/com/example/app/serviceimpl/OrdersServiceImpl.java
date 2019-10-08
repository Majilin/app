package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.OrdersMapper;
import com.example.app.model.Orders;
import com.example.app.service.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{


    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> getOrders(Integer userid) {
        return ordersMapper.getOrders(userid);
    }

    @Override
    public List<Orders> getOrderByStatus(Integer userid, Integer ordStatus) {
        return ordersMapper.getOrderByStatus(userid,ordStatus);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public Orders selectByPrimaryKey(String id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

}
