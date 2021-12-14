package com.li.jtcrm;

import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CrmApplicationTests {
    @Resource
    private UserMapper userService;
    @Test
    void contextLoads() {
    }
}
