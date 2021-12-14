package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.LoginUser;
import com.li.jtcrm.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    User selectAllByname(@Param("username") String username);
}
