package com.example.app.mapper;

import com.example.app.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    Address getaddress(@Param("aid") Integer aid, @Param("usereid") Integer userid);

    List<Address> getAlladdress(Integer userid);


    int deleteByPrimaryKey(Integer aid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}