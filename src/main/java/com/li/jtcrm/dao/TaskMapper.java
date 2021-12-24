package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.entity.Task;
import com.li.jtcrm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper extends BaseMapper<Task> {
    List<Task> TaskFindAll(@Param("page") Integer page,@Param("rows") Integer rows,@Param("zhuang") String zhuang,@Param("subject") String subject);
    User TaskId(@Param("id") int id);
    Task taskinfo(@Param("id")int id);
}
