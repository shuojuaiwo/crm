package com.li.jtcrm.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.li.jtcrm.config.AlipayConfig;
import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.impl.ProduceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    @RequestMapping("/alipay")
    @ResponseBody
    public void payController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("out_trade_no");
        // 付款金额，必填
        String total_amount = request.getParameter("total_amount");
        // 订单名称，必填
        String subject = request.getParameter("subject");
        // 商品描述，可空
        String body = request.getParameter("body");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
            System.out.println("form==>" + form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
    @RequestMapping("/returnCall")
    @ResponseBody
    public String returnCall(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println("\n验签开始.....\n");

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type); //调用SDK验证签名

        if (signVerified) {
            // 交易编号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            Map<String, Object> outTradeNoMap = new HashMap();
            outTradeNoMap.put("out_trade_no", out_trade_no);
            return "success";
        }
        return "";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "order";
    }
    }
