package com.li.jtcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/toindex")
    public String toindex(){
        return "system/index";
    }
}
