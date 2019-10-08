package com.example.app.mapper;

import com.example.app.model.Shopingbox;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopingboxMapper {
    List<Shopingbox> getshopcarlist(Integer userid);

    Shopingbox getshopcarBySid(@Param("userid")Integer sid, @Param("userid") Integer userid);

    int deleteByPrimaryKey(Integer sid);

    int insert(Shopingbox record);

    int insertSelective(Shopingbox record);

    Shopingbox selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Shopingbox record);

    int updateByPrimaryKey(Shopingbox record);
}