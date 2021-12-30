package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Lead;
import com.li.jtcrm.service.impl.LeadServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LeadController {
    @Resource
    private LeadServiceImpl leadService;

    @RequestMapping("/toLead")
    public String toLead(){
        return "views/manage/lead/lead";
    }

    @RequestMapping("/toListLead")
    public String toListLead(){
        return "views/manage/lead/list";
    }

    @RequestMapping("/listLead")
    @ResponseBody
    public Map listLead(Integer page,Integer rows,String filterSearch,String search){
        Map map=leadService.listLead(page,rows,filterSearch,search);
        return map;
    }

    @RequestMapping("/toAddAndUpdateLead")
    public String toAddAndUpdateLead(Integer id, Model model){
        leadService.toAddAndUpdateLead(id,model);
        return "views/manage/lead/add";
    }

    @RequestMapping("/addAndUpdateLead")
    @ResponseBody
    public Map addAndUpdateLead(Lead lead, HttpSession session){
        Map map=leadService.addAndUpdateLead(lead,session);
        return map;
    }

    @RequestMapping("/getLeadInfo")
    public String getLeadInfo(Integer id, Model model){
        leadService.getLeadInfo(id,model);
        return "views/manage/lead/show";
    }

    @RequestMapping(value = "/deleteLead")
    public String deleteLead(int[] ids) {
        leadService.deleteLead(ids);
        return "views/manage/lead/list";
    }
}
