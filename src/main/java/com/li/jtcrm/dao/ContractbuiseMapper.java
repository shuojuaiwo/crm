package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Contract;
import com.li.jtcrm.entity.vo.ContractVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractbuiseMapper extends BaseMapper<ContractVO> {
    void contractinsert(@Param("business_id") int business_id,@Param("contract_id") int contract_id);
}
