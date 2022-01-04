package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Record;
import com.li.jtcrm.service.impl.MarketingServiceImpl;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageController {
    @Resource
    private MarketingServiceImpl marketingService;

    @RequestMapping("/toindex2")
    public String toindex1(){
        return "views/manage/message/index_message";
    }

//    收件箱
    @RequestMapping("/toinbox")
    public String toshoubox(){
        return "views/manage/message/shoubox_message";
    }


    //发件箱
    @RequestMapping("/tooutbox2")
    public String tooutbox(){
        return "views/manage/message/index_message";
    }

//    发短信功能实现
    @RequestMapping("/tosendm")
    @ResponseBody
    //
    public Map sendmessage(String phone, String content, Record record) throws IOException {

        Map map = new HashMap();
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={
                new NameValuePair("Uid", "甜甜甜圈"),
                new NameValuePair("Key", "d41d8cd98f00b204e980"),
                new NameValuePair("smsMob",phone),
                new NameValuePair("smsText",content)

        };
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println("发送成功条数:"+result); //打印返回消息状态

        post.releaseConnection();
//        把前端html值拿过来
        map.put("success",1);
//        marketingService.save(record);
        marketingService.save(record);
        return map;


    }

    //短信收件箱
    @RequestMapping("/MaretingAll")
    @ResponseBody
    public Map Mareting(String searchBy,String contain,String text){
        System.out.println(searchBy);
        System.out.println(contain);
        System.out.println(text);
//        System.out.println(searchBy);
//        System.out.println(contain);
        Map map = marketingService.maretingAll(searchBy,contain,text);
        return map;
    }

    //删除
    @RequestMapping("/MretingDel")
    @ResponseBody
    public Map Maretingdel(int[] ids){
        System.out.println(ids);
        Map maretingdel = marketingService.Maretingdel(ids);
        return maretingdel;
    }

}
