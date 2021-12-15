package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class CustomerController {
    @Resource
    private CustomerServiceImpl customerService;

    @RequestMapping("/toAddCustomer")
    public String toAddCustomer(){
        return "views/manage/customer/add";
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public Map addCustomer(Customer customer){
        Map map=customerService.addCustomer(customer);
        return map;
    }

    @RequestMapping("/toCustomer")
    public String toCustomer(){
        return "views/manage/customer/customer";
    }

    @RequestMapping("/toList")
    public String toList(){
        return "views/manage/customer/list";
    }
}
