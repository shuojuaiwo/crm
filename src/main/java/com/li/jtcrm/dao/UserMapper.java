package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    User selectByname(@Param("username") String username);

    Map<String,Object> Muenqx(@Param("username") String username);

    List<Object> Muendz(@Param("id") int id);

    List<User> selectFindAll();
}
