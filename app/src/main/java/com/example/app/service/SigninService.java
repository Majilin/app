package com.example.app.service;

import com.example.app.model.Signin;

import java.util.List;
import java.util.Map;

public interface SigninService{


    List<Map<String,Object>> selectSignInfoByuid(int uid);

    int deleteByPrimaryKey(Integer id);

    int insert(Signin record);

    int insertSelective(Signin record);

    Signin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);

}
