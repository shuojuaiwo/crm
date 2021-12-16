package com.li.jtcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AnnouncementController {
    @RequestMapping("/toament")
    public String toament(){
        return "views/manage/announcement/list_announcement";
    }
}
