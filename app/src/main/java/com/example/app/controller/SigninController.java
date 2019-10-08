package com.example.app.controller;

import com.example.app.commons.JsonBean;
import com.example.app.model.Signin;
import com.example.app.model.Usercredit;
import com.example.app.model.WxUser;
import com.example.app.service.SigninService;
import com.example.app.service.UsercreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class SigninController {
    @Autowired
    SigninService signinService;

    @Autowired
    UsercreditService usercreditService;

    /**
     * 根据用户id查询当前用户的登录情况
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "selectSignInfoByuid", method = RequestMethod.POST)
    public JsonBean selectSignInfoByuid(HttpServletRequest session) {
        WxUser wx_user = (WxUser) session.getSession().getAttribute("wx_user");
        System.out.println(wx_user.getId());
        List<Map<String, Object>> list = signinService.selectSignInfoByuid(wx_user.getId());
        for (int i = 0; i < list.size(); i++) {
            //上次签到的时间
            Date lasttime = (Date) list.get(i).get("lasttime");

            //获取当前时间
            Date nowtime=new Date();
//Calendar calendar =new GregorianCalendar();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowtime);
            calendar.add(calendar.DATE, -1);
            nowtime = calendar.getTime();
            //SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
            //String now = format.format(nowtime);
            Signin sign=new Signin();
            if (lasttime==null){

                sign.setUid(wx_user.getId());
                sign.setLasttime(nowtime);
                signinService.updateByPrimaryKeySelective(sign);
                lasttime=sign.getLasttime();
            }
            System.out.println("lasttime" + lasttime);
            //如果当前时间-上次签到时间大于1 连续签到天数为0
            //如果当前时间-上次签到时间等于1 显示连续签到天数
            //如果当前时间-上次签到时间小于1 显示，并且无法再次签到
            if (((Math.abs((int) nowtime.getTime() - (int) lasttime.getTime()) / 3600000) / 24) > 1) {
                Signin signin = new Signin();
                signin.setUid(wx_user.getId());
                signin.setDay(0);
                signin.setStatus(1);
                int aaa = signinService.updateByPrimaryKeySelective(signin);
                System.out.println("111");
            } else if (((Math.abs((int) nowtime.getTime() - (int) lasttime.getTime()) / 3600000) / 24) == 1) {
                System.out.println("222");
                return new JsonBean(0, signinService.selectSignInfoByuid(wx_user.getId()), "success");
            } else if (((Math.abs((int) nowtime.getTime() - (int) lasttime.getTime()) / 3600000) / 24) < 1) {
                System.out.println("333");
                return new JsonBean(0, signinService.selectSignInfoByuid(wx_user.getId()), "success");
            }
        }

        return new JsonBean(0, signinService.selectSignInfoByuid(wx_user.getId()), "success");
    }

    @RequestMapping(value = "signInfoByuid", method = RequestMethod.POST)
    public JsonBean signInfoByuid(HttpServletRequest session, Date lasttime, int day,int integral) {
        WxUser wxUser = (WxUser) session.getSession().getAttribute("wx_user");
        //签到成功，用户积分+5
        Usercredit usercredit=new Usercredit();
        usercredit.setUid(wxUser.getId());
        usercredit.setIntegral(integral+5);
        usercreditService.updateByPrimaryKeySelective(usercredit);
        //修改用户签到数据
        Signin signin = new Signin();
        signin.setUid(wxUser.getId());
        signin.setStatus(0);
        signin.setDay(day + 1);
        signin.setLasttime(lasttime);
        int a = signinService.updateByPrimaryKeySelective(signin);
        //将签到成功后的数据回给页面
        signinService.selectSignInfoByuid(wxUser.getId());
        return new JsonBean(0, signinService.selectSignInfoByuid(wxUser.getId()), "success");
    }
}
