package com.example.app.mapper;

import com.example.app.model.Commodity;

import java.util.List;

public interface CommodityMapper {


    List<Commodity> selectByActice();
    List<Commodity> selectByamount();
    List<Commodity> selectorderByamount();


}