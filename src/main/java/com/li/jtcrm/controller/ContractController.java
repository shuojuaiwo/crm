package com.li.jtcrm.controller;

import com.li.jtcrm.dao.ContactMapper;
import com.li.jtcrm.dao.ContractMapper;
import com.li.jtcrm.entity.Contact;
import com.li.jtcrm.entity.Contract;
import com.li.jtcrm.entity.vo.BusinessVO;
import com.li.jtcrm.entity.vo.ContractVO;
import com.li.jtcrm.entity.vo.CustomerVO;
import com.li.jtcrm.service.impl.BusinessServiceImpl;
import com.li.jtcrm.service.impl.ContractServiceImpl;
import com.li.jtcrm.service.impl.ContractbuiesServiceImpl;
import com.li.jtcrm.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Resource
    private BusinessServiceImpl businessService;
    @Resource
    private ContractbuiesServiceImpl contractbuiesService;

    @RequestMapping("/tocontractindex")
    public String contractindex(){
        return "views/manage/contract/contract_index";
    }

    @RequestMapping("/tocontractlist")
    public String contractlist(){
        return "views/manage/contract/contract_list";
    }
    @RequestMapping("/tocontractadd")
    public String contractadd(Model model){
        List<BusinessVO> selectoriginl = businessService.selectoriginl(model);


//        List<CustomerVO> customerVOS = customerService.selectbyName();
//        List<Contact> contacts = contactMapper.selectName();
        model.addAttribute("laiy",selectoriginl);
//        model.addAttribute("kehu",customerVOS);
//        model.addAttribute("lianxi",contacts);
        return "views/manage/contract/contract_edit";
    }

    //分页和模糊查询
    @RequestMapping("/ConntractAll")
    @ResponseBody
    public Map contractpdage(int page,int rows,String contractName,String cha,String contractTwo,Model model){
        Map map=new HashMap();
        List<Contract> contracts = contractService.contractAll((page-1)*rows, rows,contractName,cha,contractTwo);
        model.addAttribute("lianxi",contracts);
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
    @RequestMapping("/contractadd")
    @ResponseBody
    public Map contractadd(Contract contract,String number,int businessId){
        Map map = contractService.contractAdd(contract);
        Contract contractbyname = contractService.contractbyname(number);
        int id = contractbyname.getId();
        contractbuiesService.contractinsert(businessId,id);
        return map;
    }
}
