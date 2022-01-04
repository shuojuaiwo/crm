package com.li.jtcrm.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketingMapper extends BaseMapper<Record> {
    List<Record> maretingall(@Param("searchBy") String searchBy,@Param("contain") String contain,@Param("text") String text);

}
