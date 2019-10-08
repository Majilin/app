package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.CreditsexchangeMapper;
import com.example.app.model.Creditsexchange;
import com.example.app.service.CreditsexchangeService;

import java.util.List;
import java.util.Map;

@Service
public class CreditsexchangeServiceImpl implements CreditsexchangeService{

    @Resource
    private CreditsexchangeMapper creditsexchangeMapper;



    /**
     * 根据skuid查询商品详情
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectCreditExchangeBySkuid(int skuid) {
        return creditsexchangeMapper.selectCreditExchangeBySkuid(skuid);
    }

    /**
     * 查询s所有积分兑换商品
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectAllCreditExchange(Integer min,Integer max) {
        return creditsexchangeMapper.selectAllCreditExchange(min,max);
    }

    @Override
    public List<Map<String, Object>> selectHotCreditExchange() {
        return creditsexchangeMapper.selectHotCreditExchange();
    }

    @Override
    public int deleteByPrimaryKey(Integer ceid) {
        return creditsexchangeMapper.deleteByPrimaryKey(ceid);
    }

    @Override
    public int insert(Creditsexchange record) {
        return creditsexchangeMapper.insert(record);
    }

    @Override
    public int insertSelective(Creditsexchange record) {
        return creditsexchangeMapper.insertSelective(record);
    }

    @Override
    public Creditsexchange selectByPrimaryKey(Integer ceid) {
        return creditsexchangeMapper.selectByPrimaryKey(ceid);
    }

    @Override
    public int updateByPrimaryKeySelective(Creditsexchange record) {
        return creditsexchangeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Creditsexchange record) {
        return creditsexchangeMapper.updateByPrimaryKey(record);
    }

}
