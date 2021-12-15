package com.li.jtcrm.controller;


import com.li.jtcrm.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password,String remember_me, HttpSession session){
        Map map1=null;
        map1 = userService.selectByname(username, password,remember_me,session);
        return map1;
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "views/index";
    }

    @RequestMapping("/toed")
    public String tocustomer(){
        return "views/manage/product/edit_product";
    }
}
