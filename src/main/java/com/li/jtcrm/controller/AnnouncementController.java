package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.service.impl.AnnouncementServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnnouncementController {
    @Resource
    private AnnouncementServiceImpl ament;
    @RequestMapping("/toament")
    public String toament(){
        return "views/manage/announcement/list_announcement";
    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "views/manage/announcement/add_announcement";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(int page, int rows){
        Map<String,Object> map = new HashMap<>();
        List<Announcement>  list = ament.selectfindpage(page-page, rows);
        int c= ament.count();
        map.put("rows",list);
        map.put("total",c);
        return map;
    }

}
