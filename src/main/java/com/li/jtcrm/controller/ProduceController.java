package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.impl.ProduceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public String ProduceAdd(String name, String creator_user_id, String link, float cost_price, float suggested_price ,String create_time,String update_time){
//        Map map=new HashMap();
        String a= String.valueOf(UUID.randomUUID());
         Produce.Produceadd(a,name,creator_user_id,link,cost_price,suggested_price,create_time,update_time);
//        if (a==1){
//            map.put("success",true);
//        }else {
//            map.put("success",false);
//        }

        return "views/manage/product/list_product";
    }

}
