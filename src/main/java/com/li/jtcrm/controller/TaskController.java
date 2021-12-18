package com.li.jtcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {
    @RequestMapping("/totask")
    public String tasklist(){
        return "views/manage/task/list_task";
    }
}
