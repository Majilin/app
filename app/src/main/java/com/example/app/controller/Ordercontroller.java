package com.example.app.controller;

import com.example.app.commons.MyJsonBean;
import com.example.app.model.*;
import com.example.app.service.AddressService;
import com.example.app.service.OrderdetailsService;
import com.example.app.service.OrdersService;
import com.example.app.service.ShopingboxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program com.example.wechat.controller
 * @auther LIUXUSHENG
 * @creattime 2019.10.03   11:32
 **/
@RequestMapping("order")
@RestController
public class Ordercontroller {


    @Resource(name = "ordersServiceImpl")
    OrdersService ordersService;

    @Resource(name = "orderdetailsServiceImpl")
    OrderdetailsService orderdetailsService;

    @Resource(name = "shopingboxServiceImpl")
    ShopingboxService shopingboxService;

    @Resource(name = "addressServiceImpl")
    AddressService addressService;

    //生成订单
    @PostMapping("addorder")
    public MyJsonBean method(Integer aid, Integer uid, Integer[] sids, Integer totprice) {
        System.out.println(sids[0]);
        System.out.println("a"+aid);
        System.out.println("u:"+uid);
        System.out.println("p:"+totprice);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<2;i++){
            result+=random.nextInt(10);
        }
        //订单id
        String orderid=newDate+result;
        //订单时间
        String ordertime=newDate;
        Orders order=new Orders();
        order.setId(orderid);
        order.setOrdertime(ordertime);
        order.setTotalprice(totprice);
        order.setAddressid(aid);
        order.setUserid(uid);
        order.setOrdStatus(0);
        int s=ordersService.insert(order);
        System.out.println("order:"+s);
        int a=-1;
        for (int i=0;i<sids.length;i++){
            Shopingbox shopingbox=shopingboxService.getshopcarBySid(sids[i],uid);
            int Salesprice=shopingbox.getRepertory().getSalesprice();
             int amount=shopingbox.getAmount();
             int skuid=shopingbox.getRepertory().getSkuid();
            Orderdetails orderdetails=new Orderdetails();
            orderdetails.setAmount(amount);
            orderdetails.setOrdid(orderid);
            orderdetails.setPrice(Salesprice);
            orderdetails.setPid(skuid);
           a=orderdetailsService.insert(orderdetails);
            System.out.println("orddet-for:"+a);
        }
        System.out.println("orddet:"+a);
        int sum=a+s;
        if (sum==2){
            return new MyJsonBean(sum,0,"success");
        }else {
            return new MyJsonBean(sum,0,"success");
        }

    }
    //获取订单
    @GetMapping(value = "getOrders")
    public MyJsonBean getOrders(HttpSession session){
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        List<Orders> orders=ordersService.getOrders(wxUser.getId());
        System.out.println(orders.size());
        Address address=new Address();
        // for (int i = 0; i < orders.size(); i++) {
        //     address=addressService.getaddress(orders.get(i).getAddressid(),wxUser.getId());
        // }
        Map<String,Object> map=new HashMap<>();
        map.put("orders",orders);
        // map.put("addresss",address);
        return new MyJsonBean(map,0,"sucess");
    }
    //根据订单状态查询订单
    @PostMapping(value = "getOrderByStatus")
    public MyJsonBean getOrderByStatus(HttpSession session,Integer ordstatus){
        WxUser wxUser= (WxUser) session.getAttribute("wx_user");
        List<Orders> orders=ordersService.getOrderByStatus(wxUser.getId(),ordstatus);
        Address address=new Address();
        for (int i = 0; i < orders.size(); i++) {
            address=addressService.getaddress(orders.get(i).getAddressid(),wxUser.getId());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orders",orders);
        map.put("addresss",address);
        return new MyJsonBean(map,0,"sucess");

    }

}
