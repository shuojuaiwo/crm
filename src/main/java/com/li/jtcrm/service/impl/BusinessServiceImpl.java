package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.BusinessMapper;
import com.li.jtcrm.dao.CustomerMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Business;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.entity.vo.BusinessVO;
import com.li.jtcrm.service.IBusinessService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Map listBusiness(Integer pagenum, Integer size) {
        Map map=new HashMap();
        Page<Object> page = new Page<>(pagenum, size);
        List<BusinessVO> vos = baseMapper.selectByPage(page);
        for (BusinessVO vo : vos) {
            String customerName = customerMapper.selectname(vo.getCustomerId());
            vo.setCustomerName(customerName);
            String ownerUser = userMapper.selectname(vo.getOwnerUserId());
            String createUser = userMapper.selectname(vo.getCreatorUserId());
            vo.setOwnerUser(ownerUser);
            vo.setCreateUser(createUser);
        }
        map.put("total", page.getTotal());
        map.put("rows", vos);
        return map;
    }

    @Override
    public void toAddBusiness(Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(queryWrapper);
        model.addAttribute("users",users);
        QueryWrapper<Customer> queryWrapper1 = new QueryWrapper<Customer>();
        List<Customer> customers = customerMapper.selectList(queryWrapper1);
        model.addAttribute("customers",customers);

        /*QueryWrapper<Contact> queryWrapper2 = new QueryWrapper<>().eq("customerId",);
        List<Contact> contacts = contactMapper.selectList(queryWrapper2);
        model.addAttribute("contacts",contacts);*/
    }

    /*@Override
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
    }*/

    /*@Override
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
    }*/
}
