package com.li.jtcrm.controller;

import com.li.jtcrm.entity.Contract;
import com.li.jtcrm.service.impl.ContractServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContractController {
    @Resource
    private ContractServiceImpl contractService;

    @RequestMapping("/tocontractindex")
    public String contractindex(){
        return "views/manage/contract/contract_index";
    }

    @RequestMapping("/tocontractlist")
    public String contractlist(){
        return "views/manage/contract/contract_list";
    }
    @RequestMapping("/tocontractadd")
    public String contractadd(){
        return "views/manage/contract/contract_edit";
    }

    //分页和模糊查询
    @RequestMapping("/ConntractAll")
    @ResponseBody
    public Map contractpage(int page,int rows,String contractName,String cha,String contractTwo){
        System.out.println(contractName);
        System.out.println(cha);
        Map map=new HashMap();
        List<Contract> contracts = contractService.contractAll((page-1)*rows, rows,contractName,cha,contractTwo);
        map.put("rows",contracts);
        return map;
    }

    //删除
    @RequestMapping("/contraectdelete")
    @ResponseBody
    public Map contractdelete(int[] ids){
        Map contraectdelete = contractService.contraectdelete(ids);
        return contraectdelete;
    }
}
