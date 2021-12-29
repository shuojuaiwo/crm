package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.jtcrm.entity.Business;
import com.li.jtcrm.entity.BusinessStatus;
import com.li.jtcrm.entity.vo.BusinessVO;

import java.util.List;

public interface BusinessMapper extends BaseMapper<Business> {
    List<BusinessVO> selectByPage(Page<?> page);
    List<BusinessVO> selectorigin();

    String selectStatusName(Integer statusId);

    List<BusinessStatus> selectStatus();

    List<String> selectOrigin();
}
