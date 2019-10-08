package com.example.app.service;

import com.example.app.model.Creditsexchange;

import java.util.List;
import java.util.Map;

public interface CreditsexchangeService{


    /**
     * 根据skuid查询商品详情
     * @return
     */
    List<Map<String,Object>> selectCreditExchangeBySkuid(int skuid);
    /**
     * 查询s所有积分兑换商品
     * @param
     * @return
     */
    List<Map<String,Object>> selectAllCreditExchange(Integer min, Integer max);

    List<Map<String,Object>> selectHotCreditExchange();

    int deleteByPrimaryKey(Integer ceid);

    int insert(Creditsexchange record);

    int insertSelective(Creditsexchange record);

    Creditsexchange selectByPrimaryKey(Integer ceid);

    int updateByPrimaryKeySelective(Creditsexchange record);

    int updateByPrimaryKey(Creditsexchange record);

}
