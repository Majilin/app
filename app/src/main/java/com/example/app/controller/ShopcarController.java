package com.example.app.controller;


import com.example.app.commons.MyJsonBean;
import com.example.app.model.Shopingbox;
import com.example.app.model.WxUser;
import com.example.app.service.ShopingboxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program com.example.wechat.controller
 * @auther LIUXUSHENG
 * @creattime 2019.10.03   11:20
 **/

@RestController
@RequestMapping("shopcar")
public class ShopcarController {

    @Resource(name = "shopingboxServiceImpl")
    ShopingboxService shopingboxService;

    //获取购物车数据
    @GetMapping(value = "getShopcarlist")
    public MyJsonBean getShopcarList(HttpSession session) {
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        List<Shopingbox> list = shopingboxService.getshopcarlist(wxUser.getId());
        MyJsonBean myJsonBean = new MyJsonBean(list, 0, "success");
        return myJsonBean;
    }

    //修改购物车数据
    @PostMapping("editShopcar")
    public MyJsonBean editShopcar(Shopingbox shopingbox) {
        int a = shopingboxService.updateByPrimaryKey(shopingbox);
        return new MyJsonBean(a, 0, "success");
    }

    @PostMapping("deleteShopcar")
    public MyJsonBean deleteShopcar(Integer[] ids) {
        int a = -1;
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] != null) {
                a = shopingboxService.deleteByPrimaryKey(ids[i]);
            }
        }
        return new MyJsonBean(a, 0, "success");
    }

    @PostMapping(value = "getshopcarBySid")
    public MyJsonBean getshopcarBySid(HttpSession session,Integer[] ids) {
       WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        List<Shopingbox> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] != null) {
                Shopingbox shopcar = shopingboxService.getshopcarBySid(ids[i],wxUser.getId());
                list.add(shopcar);
            }
        }
        MyJsonBean myJsonBean = new MyJsonBean(list, 0, "success");
        return myJsonBean;
    }

}
