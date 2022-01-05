package com.li.jtcrm.controller;

import com.li.jtcrm.entity.vo.CustomerContactVO;
import com.li.jtcrm.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/toCustomerPoolRecycle")
    public String toCustomerPoolRecycle(){
        return "views/manage/customer/CustomerPoolRecycle";
    }



    @RequestMapping("/toCustomerPool")
    public String toCustomerPool(){
        return "views/manage/customer/CustomerPool";
    }

    @RequestMapping("/listCustomer")
    @ResponseBody
    public Map listCustomer(Integer page,Integer rows,String filterSearch,String search){
        Map map=customerService.listCustomer(page,rows,filterSearch,search);
        return map;
    }

    @RequestMapping("/listCustomerPool")
    @ResponseBody
    public Map listCustomerPoll(Integer page,Integer rows,String filterSearch,String search){
        Map map=customerService.listCustomerPool(page, rows, filterSearch, search);
        return map;
    }

    @RequestMapping("/Recycleupdate")
    public Map Recycleupdate(int[] ids){
        Map recycleupdate = customerService.Recycleupdate(ids);
        return recycleupdate;
    }


    @RequestMapping("/listCustomerRecycle")
    @ResponseBody
    public Map listCustomerRecycle(Integer page,Integer rows,String filterSearch,String search){
        Map map=customerService.selectByPageRecycle(page, rows, filterSearch, search);
        return map;
    }

    @RequestMapping("/addAndUpdatePoolCustomer")
    @ResponseBody
    public Map addAndUpdatePoolCustomer(CustomerContactVO customerContactVO,HttpSession session){
        Map map=customerService.addAndUpdateCustomer(customerContactVO,session);
        return map;
    }


    @RequestMapping("/toAddAndUpdateCustomer")
    public String toAddAndUpdateCustomer(Integer id,Model model){
        customerService.toAddAndUpdateCustomer(id,model);
        return "views/manage/customer/add";
    }

    @RequestMapping("/addAndUpdateCustomer")
    @ResponseBody
    public Map addAndUpdateCustomer(CustomerContactVO customerContactVO, HttpSession session){
        Map map=customerService.addAndUpdateCustomer(customerContactVO,session);
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
