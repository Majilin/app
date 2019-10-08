package com.example.app.service;

import com.example.app.model.Commodity;

import java.util.List;
import java.util.Map;

public interface CommodityService{



    Commodity selectByPrimaryKey(Integer spuid);
    List< Commodity >selectByActice();
    List<Commodity> selectByamount();
    List<Commodity> selectorderByamount();


}
