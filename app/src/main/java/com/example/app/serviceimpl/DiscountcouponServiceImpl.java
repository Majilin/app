package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.mapper.DiscountcouponMapper;
import com.example.app.model.Discountcoupon;
import com.example.app.service.DiscountcouponService;

import java.util.List;
import java.util.Map;

@Service
public class DiscountcouponServiceImpl implements DiscountcouponService{

    @Resource
    private DiscountcouponMapper discountcouponMapper;

    /**
     * 查询所有优惠券
     * @return
     */
    @Override
    public List<Map<String, Object>> selectAllCoupon() {
        return discountcouponMapper.selectAllCoupon();
    }

    @Override
    public int deleteByPrimaryKey(Integer dcid) {
        return discountcouponMapper.deleteByPrimaryKey(dcid);
    }

    @Override
    public int insert(Discountcoupon record) {
        return discountcouponMapper.insert(record);
    }

    @Override
    public int insertSelective(Discountcoupon record) {
        return discountcouponMapper.insertSelective(record);
    }

    @Override
    public Discountcoupon selectByPrimaryKey(Integer dcid) {
        return discountcouponMapper.selectByPrimaryKey(dcid);
    }

    @Override
    public int updateByPrimaryKeySelective(Discountcoupon record) {
        return discountcouponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Discountcoupon record) {
        return discountcouponMapper.updateByPrimaryKey(record);
    }

}
