package com.li.jtcrm.controller;

import com.li.jtcrm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {

    @RequestMapping("/login")
    @ResponseBody
    public Map login(User user){
        Map map=new HashMap();
        System.out.println(user);
        map.put("success",1);
        return map;
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "system/index";
    }
}
