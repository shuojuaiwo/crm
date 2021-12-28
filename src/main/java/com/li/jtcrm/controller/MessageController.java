package com.li.jtcrm.controller;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageController {

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
    public Map sendmessage(String phone) throws IOException {
        Map map = new HashMap();
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={
                new NameValuePair("Uid", "甜甜甜圈"),
                new NameValuePair("Key", "d41d8cd98f00b204e980"),
                new NameValuePair("smsMob",phone),
                new NameValuePair("smsText","您的验证码是：457893，切勿转告他人，一分钟后失效")

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
        return map;

    }

}
