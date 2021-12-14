package com.li.jtcrm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public Map login(String username, String password){
        Map map = new HashMap();
        System.out.println(username);
        System.out.println(password);
        map.put("success","1");
        return map;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "system/index";
    }
}
