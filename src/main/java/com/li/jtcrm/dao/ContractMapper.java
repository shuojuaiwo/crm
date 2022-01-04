package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Contact;
import com.li.jtcrm.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractMapper extends BaseMapper<Contract> {
    List<Contract> selectContract(@Param("page") int page,@Param("rows") int rows,@Param("contractName") String contractName ,@Param("cha") String cha,@Param("contractTwo") String contractTwo);
    Contract contractbyName(@Param("number") String number);
    Contract contractShow(@Param("id") int id);
}
