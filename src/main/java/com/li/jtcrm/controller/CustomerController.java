package com.li.jtcrm.controller;

import com.li.jtcrm.entity.vo.CustomerContactVO;
import com.li.jtcrm.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Map listCustomer(Integer page,Integer rows){
        Map map=customerService.listCustomer(page,rows);
        return map;
    }

    @RequestMapping("/toAddAndUpdateCustomer")
    public String toAddAndUpdateCustomer(Integer id,Model model){
        customerService.toAddAndUpdateCustomer(id,model);
        return "views/manage/customer/add";
    }

    @RequestMapping("/addAndUpdateCustomer")
    @ResponseBody
    public Map addAndUpdateCustomer(CustomerContactVO customerContactVO){
        Map map=customerService.addAndUpdateCustomer(customerContactVO);
        return map;
    }

    @RequestMapping("/getCustomerInfo")
    public String getCustomerInfo(Integer id,Model model){
        customerService.getCustomerInfo(id,model);
        return "views/manage/customer/show";
    }

    @RequestMapping(value = "/deleteCustomer")
    public String deleteCustomer(int[] ids) {
        customerService.deleteCustomer(ids);
        return "views/manage/customer/list";
    }
}
