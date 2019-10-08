package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.UsercreditMapper;
import com.example.app.model.Usercredit;
import com.example.app.service.UsercreditService;
@Service
public class UsercreditServiceImpl implements UsercreditService{

    @Resource
    private UsercreditMapper usercreditMapper;

    @Override
    public int deleteByPrimaryKey(Integer ucid) {
        return usercreditMapper.deleteByPrimaryKey(ucid);
    }

    @Override
    public int insert(Usercredit record) {
        return usercreditMapper.insert(record);
    }

    @Override
    public int insertSelective(Usercredit record) {
        return usercreditMapper.insertSelective(record);
    }

    @Override
    public Usercredit selectByPrimaryKey(Integer ucid) {
        return usercreditMapper.selectByPrimaryKey(ucid);
    }

    @Override
    public int updateByPrimaryKeySelective(Usercredit record) {
        return usercreditMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Usercredit record) {
        return usercreditMapper.updateByPrimaryKey(record);
    }

}
