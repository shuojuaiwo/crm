package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ContractMapper;
import com.li.jtcrm.dao.ContractbuiseMapper;
import com.li.jtcrm.entity.Contract;
import com.li.jtcrm.entity.vo.ContractVO;
import com.li.jtcrm.service.IContractService;
import com.li.jtcrm.service.IContractbuiesService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractbuiesServiceImpl extends ServiceImpl<ContractbuiseMapper, ContractVO> implements IContractbuiesService {

    public void contractinsert(int business_id,int contract_id){
        baseMapper.contractinsert(business_id, contract_id);
    }
}
