package com.li.jtcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @RequestMapping("/toAddCustomer")
    public String toAddCustomer(){
        return "views/manage/customer/add";
    }
}
