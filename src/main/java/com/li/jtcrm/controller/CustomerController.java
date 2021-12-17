package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class CustomerController {
    @Resource
    private CustomerServiceImpl customerService;

    @RequestMapping("/toCustomer")
    public String toCustomer(){
        return "views/manage/customer/customer";
    }

    @RequestMapping("/toListCustomer")
    public String toListCustomer(){
        return "views/manage/customer/list";
    }

    @RequestMapping("/listCustomer")
    @ResponseBody
    public Map listCustomer(@RequestParam(defaultValue = "1") Integer pagenum, @RequestParam(defaultValue = "10") Integer size){
        Map map=customerService.listCustomer(pagenum,size);
        return map;
    }

    @RequestMapping("/toAddCustomer")
    public String toAddCustomer(Model model){
        customerService.toAddCustomer(model);
        return "views/manage/customer/add";
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public Map addCustomer(Customer customer){
        Map map=customerService.addCustomer(customer);
        return map;
    }
}
