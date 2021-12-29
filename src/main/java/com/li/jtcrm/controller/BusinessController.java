package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Business;
import com.li.jtcrm.service.impl.BusinessServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class BusinessController {
    @Resource
    private BusinessServiceImpl businessService;

    @RequestMapping("/toBusiness")
    public String toBusiness(){
        return "views/manage/business/business";
    }

    @RequestMapping("/toListBusiness")
    public String toListBusiness(){
        return "views/manage/business/list";
    }

    @RequestMapping("/listBusiness")
    @ResponseBody
    public Map listBusiness(@RequestParam(defaultValue = "1") Integer pagenum, @RequestParam(defaultValue = "10") Integer size){
        Map map=businessService.listBusiness(pagenum,size);
        return map;
    }

    @RequestMapping("/toAddAndUpdateBusiness")
    public String toAddAndUpdateBusiness(Integer id,Model model){
        businessService.toAddAndUpdateBusiness(id,model);
        return "views/manage/business/edit";
    }


    @RequestMapping("/addAndUpdateBusiness")
    @ResponseBody
    public Map addAndUpdateBusiness(Business business){
        Map map=businessService.addAndUpdateBusiness(business);
        return map;
    }

    @RequestMapping("/getBusinessInfo")
    public String getBusinessInfo(Integer id,Model model){
        businessService.getBusinessInfo(id,model);
        return "views/manage/business/see";
    }

    @RequestMapping("/getBusinessStatus")
    @ResponseBody
    public Map getBusinessType(){
        Map map=businessService.getBusinessStatus();
        return map;
    }

    @RequestMapping("/getBusinessOrigin")
    @ResponseBody
    public Map getBusinessOrigin(){
        Map map=businessService.getBusinessOrigin();
        return map;
    }

    @RequestMapping("/getBusinessContact")
    @ResponseBody
    public Map getBusinessContact(Integer id){
        Map map=businessService.getBusinessContact(id);
        return map;
    }
}
