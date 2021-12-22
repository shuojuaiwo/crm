package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.impl.ProduceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class ProduceController {
    @Resource
    private ProduceServiceImpl Produce;
    @RequestMapping("/toed")
    public String tocustomer(){
        return "views/manage/product/list_product";
    }
    @RequestMapping("/toaddd")
    public String add(){
        return "views/manage/product/edit_product";
    }

    //去更新
    @RequestMapping("/toProduceUpdate")
    public String toupdate(Model model,int id){
        Produce update = Produce.show(id);
        model.addAttribute("toupdate",update);
        return "views/manage/product/update_product";
    }

    //更新
    @RequestMapping("/ProduceUpdate")
    @ResponseBody
    public Map ProduceUpdate(Produce produce){
        Map map=new HashMap();
        boolean b = Produce.updateById(produce);
        if (b){
            map.put("success",true);
            map.put("message","更新成功");
        }else {
            map.put("success",false);
            map.put("message","更新失败");
        }
        return map;
    }

    //分页展示
    @RequestMapping("/ProduceAll")
    @ResponseBody
    public Map ProduceAllPage(int page,int rows,String name,Float suggestedprice){

        Map map = new HashMap();
        List<Produce> produces = Produce.ProduceAllPage((page-1)*rows, rows,name,suggestedprice);
        int ProduceTotal=Produce.count();
        map.put("rows",produces);
        map.put("total",ProduceTotal);
        return map;
    }
    //添加
    @RequestMapping("/ProduceAdd")
    @ResponseBody
    public Map ProduceAdd(Produce produce){
        Map map=new HashMap();
        boolean save = Produce.save(produce);
        if (save){
            map.put("success",true);
            map.put("message","添加成功");
        }else {
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }
    //详情
    @RequestMapping("/toProduceshow")
    public String toupdate(int id, Model model){
        Produce show = Produce.show(id);
        model.addAttribute("show",show);
        return "views/manage/product/show_product";
    }



    //逻辑删除
    @RequestMapping("/ProduceDelete")
    @ResponseBody
    public Map ProduceDelete(int[] ids){
      Map  map=  Produce.Delete(ids);
        return map;
    }
    @RequestMapping("/mohu")
    public Map mohu(String name,float suggested_price){
        Map map=new HashMap();
       List<Produce> list= Produce.mohu(name, suggested_price);
        map.put("rows",list);
        return map;
    }

}
