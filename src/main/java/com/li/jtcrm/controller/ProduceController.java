package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.impl.ProduceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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


    @RequestMapping("/ProduceAll")
    @ResponseBody
    public Map ProduceAllPage(int page,int rows){
        Map map = new HashMap();
        List<Produce> produces = Produce.ProduceAllPage((page-1)*rows, rows);
        int ProduceTotal=Produce.count();
        map.put("rows",produces);
        map.put("total",ProduceTotal);
        return map;
    }

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
    @RequestMapping("/ProduceUpdate")
    public String ProduceUpdate(int id){
        System.out.println(id);
        return "views/manage/product/list_product";
    }
    @RequestMapping("/ProduceDelete")
    @ResponseBody
    public Map ProduceDelete(int[] ids){
      Map  map=  Produce.Delete(ids);
        return map;
    }

}
