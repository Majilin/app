package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.UserdiscountMapper;
import com.example.app.model.Userdiscount;
import com.example.app.service.UserdiscountService;
@Service
public class UserdiscountServiceImpl implements UserdiscountService{

    @Resource
    private UserdiscountMapper userdiscountMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userdiscountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Userdiscount record) {
        return userdiscountMapper.insert(record);
    }

    @Override
    public int insertSelective(Userdiscount record) {
        return userdiscountMapper.insertSelective(record);
    }

    @Override
    public Userdiscount selectByPrimaryKey(Integer id) {
        return userdiscountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Userdiscount record) {
        return userdiscountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userdiscount record) {
        return userdiscountMapper.updateByPrimaryKey(record);
    }

}
