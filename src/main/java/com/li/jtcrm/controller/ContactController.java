package com.li.jtcrm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.jtcrm.dao.ContactMapper;
import com.li.jtcrm.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContactController {
    @Resource
    private ContactMapper contactMapper;

    @RequestMapping("/findCustomer")
    @ResponseBody
    public Map findCustomer(Integer id){
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<Contact>().eq("customer_id", id);
        List<Contact> contacts = contactMapper.selectList(queryWrapper);
        //model.addAttribute("contacts",contacts);
        Map map=new HashMap();
        map.put("data",contacts);
        return map;
    }
}
