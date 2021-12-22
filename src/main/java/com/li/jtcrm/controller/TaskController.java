package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Task;
import com.li.jtcrm.service.impl.TaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TaskController {
    @Resource
    private TaskServiceImpl taskService;

    @RequestMapping("/totask")
    public String toTask(){
        return "views/manage/task/list_task";
    }
    @RequestMapping("/toTaskAdd")
    public String toTaskAdd(){
        return "views/manage/task/add_task";
    }


    //分页
    @RequestMapping("/TaskAll")
    @ResponseBody
    public Map tasklist(Integer page,Integer rows,String taskVo,String subject){
        System.out.println(taskVo);
        System.out.println(subject);
        Map map=new HashMap();
        Map tasks = taskService.TaskFindPageAll(page, rows,taskVo,subject);
        map.put("rows",tasks);
        return tasks;
    }

    //添加
    @RequestMapping("/taskAdd")
    @ResponseBody
    public Map taskAdd(Task task){
        Map map = new HashMap();
        System.out.println(task);
        boolean save = taskService.save(task);
        if (save){
            map.put("success",1);
            map.put("message","添加成功");
        }else {
            map.put("success",0);
            map.put("message","添加失败");
        }
        return map;
    }
}
