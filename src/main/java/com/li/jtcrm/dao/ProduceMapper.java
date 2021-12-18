package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Produce;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceMapper extends BaseMapper<Produce> {
    List<Produce> ProduceAll(@Param("page") int page,@Param("rows") int rows);
    Produce ProduceShow(@Param("id") int id);

    List<Produce> mohucha(@Param("name") String name,@Param("suggested_price") float suggested_price);
}
