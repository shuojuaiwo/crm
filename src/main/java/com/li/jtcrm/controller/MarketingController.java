package com.li.jtcrm.controller;

import com.li.jtcrm.mail.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MarketingController {

    @Resource
    private MailService mailService;
    //
    @RequestMapping("/toindex1")
    public String toindex1(){
        return "views/manage/marketing/index_marketing";
    }

    //去发送邮件
    @RequestMapping("/tosendemail")
    public String tosendemail(){
        return "views/manage/marketing/sendemail_marketing";
    }

    //去发送短信
    @RequestMapping("/tosendmsg")
    public String tosendmsg(){
        return "views/manage/marketing/sendmsg_marketing";
    }

    //去短信发件箱
    @RequestMapping("/tooutbox")
    public String tooutbox(){
        return "views/manage/marketing/outbox_marketing";

    }



    //发邮件功能
    @RequestMapping("/email")
    @ResponseBody
    public Map toemail(String qq,String subject,String content){
        Map map = new HashMap();
        mailService.sendHtmlMail(qq,subject,content);
        String s=qq;

       int a= s.indexOf("@");
       int b=s.indexOf(".com");
        if (a ==-1||b==-1||a>b){
            map.put("success",0);
        }else {
            map.put("success",1);
        }
        return map;
    }




}
