package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.SigninMapper;
import com.example.app.model.Signin;
import com.example.app.service.SigninService;

import java.util.List;
import java.util.Map;

@Service
public class SigninServiceImpl implements SigninService{


    @Resource
    private SigninMapper signinMapper;

    @Override
    public List<Map<String, Object>> selectSignInfoByuid(int uid) {
        return signinMapper.selectSignInfoByuid(uid);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return signinMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Signin record) {
        return signinMapper.insert(record);
    }

    @Override
    public int insertSelective(Signin record) {
        return signinMapper.insertSelective(record);
    }

    @Override
    public Signin selectByPrimaryKey(Integer id) {
        return signinMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Signin record) {
        return signinMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Signin record) {
        return signinMapper.updateByPrimaryKey(record);
    }


}
