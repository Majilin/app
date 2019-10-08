package com.example.app.controller;

import com.example.app.commons.JsonBean;
import com.example.app.model.Ucreditexchangedetails;
import com.example.app.model.Usercredit;
import com.example.app.model.WxUser;
import com.example.app.service.CreditsexchangeService;
import com.example.app.service.UcreditexchangedetailsService;
import com.example.app.service.UsercreditService;
import com.example.app.service.UserdiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class CreditExchangeController {

    @Autowired
    CreditsexchangeService creditsexchangeService;

    @Autowired
    UsercreditService usercreditService;

    @Autowired
    UcreditexchangedetailsService ucreditexchangedetailsService;

    @Autowired
    UserdiscountService userdiscountService;


    /**
     * 查询热门兑换商品
     * 根据商品库存，小于所有商品库存平均数即为热门商品
     *
     * @return
     */
    @RequestMapping(value = "selectHotCreditExchange", method = RequestMethod.POST)
    public JsonBean selectCreditExchange() {
        System.out.println("aaa");
        return new JsonBean(0, creditsexchangeService.selectHotCreditExchange(), "success");
    }

    /**
     * 查询所有兑换商品项
     *
     * @return
     */
    @RequestMapping(value = "selectAllCreditExchange", method = RequestMethod.POST)
    public JsonBean selectAllCreditExchange(@RequestParam(required = false)Integer min,@RequestParam(required = false)Integer max) {
        return new JsonBean(0, creditsexchangeService.selectAllCreditExchange(min,max), "success");
    }


    /**
     * 根据skuid
     *
     * @param skuid 兑换商品详情
     * @return
     */
    @RequestMapping(value = "selectCreditExchangeBySkuid", method = RequestMethod.POST)
    public JsonBean selectCreditExchangeBySkuid(int skuid) {
        return new JsonBean(0, creditsexchangeService.selectCreditExchangeBySkuid(skuid), "success");
    }

    /**
     * 积分兑换商品
     *
     * @param skuid
     * @param integral
     * @return
     */
    @RequestMapping(value = "CreditExchangeBySkuid", method = RequestMethod.POST)
    public JsonBean CreditExchangeBySkuid(HttpServletRequest session, int skuid, int integral) {
        WxUser wxUser = (WxUser) session.getSession().getAttribute("wx_user");
        //根据用户id查询出用户的积分信息
        Usercredit usercredit = usercreditService.selectByPrimaryKey(wxUser.getId());


        if (usercredit.getIntegral() > integral || usercredit.getIntegral() == integral) {
            Ucreditexchangedetails ucreditexchangedetails = new Ucreditexchangedetails();
            ucreditexchangedetails.setSkuid(skuid);
            ucreditexchangedetails.setUid(usercredit.getUid());

            ucreditexchangedetailsService.insert(ucreditexchangedetails);

            usercredit.setIntegral(usercredit.getIntegral() - integral);
            usercreditService.updateByPrimaryKeySelective(usercredit);

            return new JsonBean(0, "兑换商品成功", "success");

        } else {
            return new JsonBean(1, "积分不足", "no");
        }
    }

    @RequestMapping("selectAllExchangeByUid")
    public JsonBean selectAllExchangeByUid(HttpServletRequest session) {
        WxUser wxUser = (WxUser) session.getSession().getAttribute("wx_user");
        List<Map<String, Object>> list = ucreditexchangedetailsService.selectAllExchangeByuid(wxUser.getId());
        if (list.size()!=0){
            return new JsonBean(0,ucreditexchangedetailsService.selectAllExchangeByuid(wxUser.getId()),"success");
        }else {
            return new JsonBean(1,"none","success");
        }

    }

}
