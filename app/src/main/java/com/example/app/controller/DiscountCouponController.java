package com.example.app.controller;

import com.example.app.commons.JsonBean;
import com.example.app.model.Discountcoupon;
import com.example.app.model.Usercredit;
import com.example.app.model.Userdiscount;
import com.example.app.model.WxUser;
import com.example.app.service.DiscountcouponService;
import com.example.app.service.UsercreditService;
import com.example.app.service.UserdiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DiscountCouponController {

    @Autowired
    DiscountcouponService discountcouponService;

    @Autowired
    UsercreditService usercreditService;

    @Autowired
    UserdiscountService userdiscountService;


    /**
     * 查询所有优惠券
     *
     * @return
     */
    @RequestMapping(value = "/selectAllCoupon", method = RequestMethod.POST)
    public JsonBean selectAllCoupon() {
        return new JsonBean(0, discountcouponService.selectAllCoupon(), "success");
    }

    /**
     * 查询 用户积分
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "selectUserCreditByUserid", method = RequestMethod.POST)
    public JsonBean selectUserCreditByUserid(HttpServletRequest session, int dcid) {
        WxUser wxUser = (WxUser) session.getSession().getAttribute("wx_user");

        //根据用户id查询出用户的积分信息
        Usercredit usercredit = usercreditService.selectByPrimaryKey(wxUser.getId());

        Discountcoupon discountcoupon = discountcouponService.selectByPrimaryKey(dcid);


        //如果用户积分大于等于优惠券所需积分，执行兑换
        if (usercredit.getIntegral() > discountcoupon.getIntegral() || usercredit.getIntegral() == discountcoupon.getIntegral()) {
            Userdiscount userdiscount = new Userdiscount();
            userdiscount.setDcid(dcid);
            userdiscount.setUdcStatus(discountcoupon.getDcStatus());
            userdiscount.setUid(usercredit.getUid());
            //在用户兑换优惠券表添加一条数据
            userdiscountService.insert(userdiscount);
            //添加后，用户积分减少
            usercredit.setIntegral(usercredit.getIntegral() - discountcoupon.getIntegral());
            usercreditService.updateByPrimaryKeySelective(usercredit);
            return new JsonBean(0, "兑换成功", "yes");
        } else {
            return new JsonBean(1, "积分不足", "no");
        }

    }
}
