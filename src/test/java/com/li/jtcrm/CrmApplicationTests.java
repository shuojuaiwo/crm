package com.li.jtcrm;

import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@SpringBootTest
class CrmApplicationTests {
    @Resource
    private UserMapper userService;
    @Test
    void contextLoads() {
    }
    @Test
    private void aa(){
    }

}
