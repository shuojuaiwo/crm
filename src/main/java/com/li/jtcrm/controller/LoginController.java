package com.li.jtcrm.controller;


import com.li.jtcrm.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserServiceImpl userService;


    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password){
        Map map1 = userService.selectByname(username, password);
        return map1;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "system/index";
    }
}
