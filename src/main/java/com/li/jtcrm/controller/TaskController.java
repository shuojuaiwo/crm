package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Task;
import com.li.jtcrm.service.impl.TaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

        Map tasks = taskService.TaskFindPageAll(page, rows,taskVo,subject);
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

    //任务删除
    @RequestMapping("/taskdelete")
    @ResponseBody
    public Map TaskDelete(int[] ids){
        Map map = taskService.TaskDelete(ids);
        return map;
    }

    //详情
    @RequestMapping("/totaskshow")
    public String totaskshow(int id, Model model){
        Task task = taskService.TaskInfoById(id);
        model.addAttribute("taskinfo",task);
        return "views/manage/task/show_task";
    }
    //去更新
    @RequestMapping("/totaskupdate")
    public String totaskupdate(int id, Model model){
        Task task = taskService.TaskInfoById(id);
        model.addAttribute("taskinfo",task);
        return "views/manage/task/modify_task";
    }
    //更新
    @RequestMapping("/TaskUpdate")
    @ResponseBody
    public Map TaskUpdate(Task task){
        Map map = new HashMap();
        boolean save = taskService.updateById(task);
        if (save){
            map.put("success",1);
            map.put("message","更新成功");
        }else {
            map.put("success",0);
            map.put("message","更新失败");
        }
        return map;
    }
}
