package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Ucreditexchangedetails;
import com.example.app.mapper.UcreditexchangedetailsMapper;
import com.example.app.service.UcreditexchangedetailsService;

import java.util.List;
import java.util.Map;

@Service
public class UcreditexchangedetailsServiceImpl implements UcreditexchangedetailsService{

    @Resource
    private UcreditexchangedetailsMapper ucreditexchangedetailsMapper;

    /**
     * 根据用户id查询该用户已兑换的商品
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectAllExchangeByuid(int uid) {
        return ucreditexchangedetailsMapper.selectAllExchangeByuid(uid);
    }
    @Override
    public int deleteByPrimaryKey(Integer ucedid) {
        return ucreditexchangedetailsMapper.deleteByPrimaryKey(ucedid);
    }

    @Override
    public int insert(Ucreditexchangedetails record) {
        return ucreditexchangedetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(Ucreditexchangedetails record) {
        return ucreditexchangedetailsMapper.insertSelective(record);
    }

    @Override
    public Ucreditexchangedetails selectByPrimaryKey(Integer ucedid) {
        return ucreditexchangedetailsMapper.selectByPrimaryKey(ucedid);
    }

    @Override
    public int updateByPrimaryKeySelective(Ucreditexchangedetails record) {
        return ucreditexchangedetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ucreditexchangedetails record) {
        return ucreditexchangedetailsMapper.updateByPrimaryKey(record);
    }

}
