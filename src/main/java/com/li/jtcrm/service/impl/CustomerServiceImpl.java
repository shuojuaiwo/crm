package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ContactMapper;
import com.li.jtcrm.dao.CustomerMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Contact;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private ContactMapper contactMapper;

    @Override
    public Map listCustomer(Integer pagenum, Integer size) {
        Map map=new HashMap();
        Page<Object> page = new Page<>(pagenum, size);
        List<Map<String, Object>> list = baseMapper.selectByPage(page);
        for (Map<String, Object> map1 : list) {
            Integer owner_user_id = (Integer) map1.get("owner_user_id");
            Integer creator_user_id = (Integer) map1.get("creator_user_id");
            String ownerUser = userMapper.selectById(owner_user_id).getUsername();
            String createUser = userMapper.selectById(creator_user_id).getUsername();
            map1.put("ownerUser",ownerUser);
            map1.put("createUser",createUser);
        }
        map.put("total", page.getTotal());
        map.put("rows", list);
        return map;
    }

    @Override
    public void toAddCustomer(Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(queryWrapper);
        model.addAttribute("users",users);
    }

    @Override
    public Map addCustomer(Customer customer) {
        Map map=new HashMap();
        boolean b = save(customer);
        if (b){
            map.put("msg","添加成功！");
            map.put("success",1);
        }else{
            map.put("msg","添加失败！");
            map.put("success",0);
        }
        return map;
    }

    @Override
    public void getCustomerInfo(Integer id, Model model) {
        Customer customer = baseMapper.selectById(id);
        System.out.println(customer);
        model.addAttribute("customer",customer);
        String owner = userMapper.selectById(customer.getOwnerUserId()).getUsername();
        model.addAttribute("owner",owner);
        Contact contact = contactMapper.selectContact(customer.getId());
        model.addAttribute("contact",contact);
        User createUser = userMapper.selectById(customer.getCreatorUserId());
        model.addAttribute("createUser",createUser);
    }
}
