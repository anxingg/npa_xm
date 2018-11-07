package com.zkpt.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkpt.data.entity.GasUser;
import com.zkpt.data.service.GasUserServiceI;
import com.zkpt.middleware.service.IMwFactoryService;
import com.zkpt.redis.service.IRedisService;

@Controller
public class DemoController {
    @Autowired
    private IMwFactoryService mwFactoryService;

    @Autowired
    private GasUserServiceI gasUserService;

    @Autowired
    private IRedisService redisService;

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        GasUser gasUser = new GasUser();
        gasUser.setUserName("赵琦");
        gasUser.setUserNo("0001");
        gasUser.setCreateDate(new Date());
        gasUser.setCreateBy("system");
        gasUserService.insert(gasUser);
        redisService.set("2", "ddddd");
        System.out.println(redisService.get("1"));
        System.out.println(redisService.get("userArrear:100100170008"));
        redisService.setMessage(22L);
        return "demo";
    }

    @RequestMapping("hello1")
    @ResponseBody
    public String hello(HttpServletResponse res) {
        String xx = "[{\"_name\":\"湖南省\",\"_regionId\":134},{\"_name\":\"北京市\",\"_regionId\":143}]";
        return xx;
    }

}
