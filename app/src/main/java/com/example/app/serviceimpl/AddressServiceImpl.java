package com.example.app.serviceimpl;

import com.example.app.commons.MyJsonBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Address;
import com.example.app.mapper.AddressMapper;
import com.example.app.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Resource
    private AddressMapper addressMapper;

    @Override
    public MyJsonBean getAlladdress(Integer userid) {
        List<Address> list=addressMapper.getAlladdress(userid);
        return new MyJsonBean(list,0,"success");
    }

    @Override
    public Address getaddress(Integer aid,Integer userid) {
        return addressMapper.getaddress(aid,userid);
    }

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return addressMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public Address selectByPrimaryKey(Integer aid) {
        return addressMapper.selectByPrimaryKey(aid);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

}
