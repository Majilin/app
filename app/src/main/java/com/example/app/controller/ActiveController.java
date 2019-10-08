package com.example.app.controller;

import com.example.app.commons.JsonUtil;
import com.example.app.model.Commodity;
import com.example.app.model.JsonType;
import com.example.app.model.Repertory;
import com.example.app.service.CommodityService;
import com.example.app.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ActiveController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private RepertoryService repertoryService;

    @RequestMapping(value = "active")
    public  List<Commodity> active(){
        List<Commodity> commodity = commodityService.selectByActice();
        System.out.println(commodity.size());
        return  commodity;
    }
    @RequestMapping(value = "selectByamount")
    public  List<Commodity> selectByamount(){
        List<Commodity> commodity = commodityService.selectByamount();
        System.out.println(commodity.size());
        return  commodity;
    }

    @RequestMapping(value = "selectorderByamount")
    public  List<Commodity> selectorderByamount(){
        List<Commodity> commodity = commodityService.selectorderByamount();
        System.out.println(commodity.size());
        return  commodity;
    }
    @RequestMapping(value = "selectrepertory")
    public JsonType selectrepertory(Integer skuid){
        Repertory repertory=repertoryService.selectByPrimaryKey(skuid);
        return  new JsonType("",repertory,"success");
    }

}
