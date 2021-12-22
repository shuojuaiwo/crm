package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.service.impl.AnnouncementServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    //去公告表
    @RequestMapping("/toament")
    public String toament(){
        return "views/manage/announcement/list_announcement";
    }

    //分页展示功能
    @RequestMapping("/list")
    @ResponseBody
    public Map list(int page, int rows,String title,String name){
        Map<String,Object> map = new HashMap<>();
        List<Announcement>  list = ament.SelectFindPage((page-1)*rows, rows,title,name);
        int c= ament.count();
        map.put("rows",list);
        map.put("total",c);
        return map;
    }


    //去添加功能实现
    @RequestMapping("/toadd")
    public String toadd(){
        return "views/manage/announcement/add_announcement";
    }

   //添加功能实现
    @RequestMapping("/add")
    @ResponseBody
    public Map add(Announcement announcement){
        Map map = new HashMap();
       boolean b =  ament.save(announcement);
       if (b){
           map.put("success",true);
           map.put("message","添加成功");
       }else{
           map.put("success",false);
           map.put("message","添加失败");
       }

        return map ;
    }

    //去修改
    @RequestMapping("/toupdate")
    public String toupdate(int id, Model model){
        Announcement announcement = ament.selectById(id);
        model.addAttribute("aa",announcement);
        return "views/manage/announcement/update_announcement";

    }

    //修改
    @RequestMapping("/update")
    @ResponseBody
    public Map update(Announcement announcement){
        Map map = new HashMap();
        boolean c = ament.updateById(announcement);
        if(c){
            map.put("success",true);
            map.put("message","修改成功");
        }else{
            map.put("success",false);
            map.put("message","修改失败");
        }
        return map;

    }

    //删除功能实现
    @RequestMapping("/todelete")
    @ResponseBody
    public Map delete(int[] ids){
      Map map = ament.delete(ids);
      return  map;
    }


    //查看详情功能实现
    @RequestMapping("/toinfo")
    public String selectinfo(int id,Model model){
        Announcement selectinfo = ament.selectinfo(id);
        model.addAttribute("info",selectinfo);
        return "views/manage/announcement/info_announcement";
    }






    }


