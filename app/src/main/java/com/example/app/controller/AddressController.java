package com.example.app.controller;


import com.example.app.commons.MyJsonBean;
import com.example.app.model.Address;
import com.example.app.model.WxUser;
import com.example.app.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @program com.example.wechat.controller
 * @auther LIUXUSHENG
 * @creattime 2019.10.04   14:15
 **/


@RestController
@RequestMapping(value = "address")
public class AddressController {
    @Resource(name = "addressServiceImpl")
    AddressService addressService;

    @GetMapping(value = "getAlladdress")
    public MyJsonBean getAlladdress(HttpSession session) {
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        return addressService.getAlladdress(wxUser.getId());
    }

    @PostMapping(value = "getaddressByaid")
    public MyJsonBean getaddressByaid(HttpSession session,Integer aid) {
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        Address address = addressService.getaddress(aid,wxUser.getId());
        return new MyJsonBean(address, 0, "sucess");
    }
}
