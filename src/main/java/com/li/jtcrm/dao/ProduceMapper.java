package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Produce;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProduceMapper extends BaseMapper<Produce> {
    List<Produce> ProduceAll(@Param("page") int page,@Param("rows") int rows);
    void ProduceAdd(@Param("id") String id,@Param("name") String name,@Param("creator_user_id") String creator_user_id,@Param("link") String link,@Param("cost_price") float cost_price,@Param("suggested_price") float suggested_price ,@Param("create_time") String create_time,@Param("update_time") String update_time);
}
