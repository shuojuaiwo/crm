package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ContactMapper;
import com.li.jtcrm.dao.ContractMapper;
import com.li.jtcrm.dao.CustomerMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Contact;
import com.li.jtcrm.entity.Contract;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.entity.vo.ContractVO;
import com.li.jtcrm.entity.vo.CustomerContactVO;
import com.li.jtcrm.entity.vo.CustomerVO;
import com.li.jtcrm.service.IContractService;
import com.li.jtcrm.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    public List<Contract> contractAll(int page,int rows,String contractName,String cha,String contractTwo){
        List<Contract> contracts = baseMapper.selectContract(page, rows,contractName,cha,contractTwo);
        return contracts;
    }

    public Map contraectdelete(int[] ids){
        Map map = new HashMap();
        for(int i :ids){
            int i1 = baseMapper.deleteById(i);
        }
        map.put("success",1);
        map.put("message","删除成功");
        return map;
    }

    public Map contractAdd(Contract contract){
        Map map = new HashMap();
        int insert = baseMapper.insert(contract);
        if (insert==1){
            map.put("success",true);
            map.put("message","添加成功");
        }else {
            map.put("success",false);
            map.put("message","添加失败");
        }
        return map;
    }

    public Contract contractbyname(String number){
        Contract contract = baseMapper.contractbyName(number);
        return contract;
    }
}
