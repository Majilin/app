package com.example.app.mapper;

import com.example.app.model.WxUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
@Mapper
public interface WxUserMapper extends BaseMapper<WxUser> {
    WxUser selectByOpenId(String  openid);
    int insert(WxUser record);

}