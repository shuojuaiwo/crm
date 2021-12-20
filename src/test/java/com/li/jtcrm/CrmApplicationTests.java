package com.li.jtcrm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.jtcrm.dao.AnnouncementMapper;
import com.li.jtcrm.dao.CustomerMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CrmApplicationTests {
    @Resource
    private UserMapper userService;
    @Resource
    private AnnouncementMapper announcementMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Test
    void contextLoads() {
    }
    @Test
    private void aa(){
    }

    @Test
    public void test1(){
        QueryWrapper<Customer> wrapper = new QueryWrapper<Customer>();
        Page<Customer> page = customerMapper.selectPage(new Page<>(1, 2), wrapper);
        for (Customer customer : page.getRecords()) {
            System.out.println(customer);
        }
    }
    @Test
    public void test2(){
//       int a= userService.Muenqx("admin");
        System.out.println(userService.Muendz(1));

    }
    @Test
    public void text3(){
        System.out.println(announcementMapper.SelectInfo(2));
    }
}
