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
import com.li.jtcrm.entity.vo.CustomerContactVO;
import com.li.jtcrm.entity.vo.CustomerVO;
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
    public Map listCustomer(Integer page, Integer rows,String filterSearch,String search) {
        Map map=new HashMap();
        Page<Object> page1 = new Page<>(page, rows);
        System.out.println(filterSearch);
        System.out.println(search);
        List<CustomerVO> vos = baseMapper.selectByPage(page1,filterSearch,search);
        for (CustomerVO vo : vos) {
            String ownerUser = userMapper.selectById(vo.getOwnerUserId()).getUsername();
            String createUser = userMapper.selectById(vo.getCreatorUserId()).getUsername();
            vo.setOwnerUser(ownerUser);
            vo.setCreateUser(createUser);
        }
        map.put("total", page1.getTotal());
        map.put("rows", vos);
        return map;
    }

    @Override
    public void toAddAndUpdateCustomer(Integer id, Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(queryWrapper);
        model.addAttribute("users",users);
        if (id!=null){
            Customer customer = baseMapper.selectById(id);
            model.addAttribute("customer",customer);
            Contact contact = contactMapper.selectContact(customer.getId());
            model.addAttribute("contact",contact);
        }
    }                                                    

    @Override
    public Map addAndUpdateCustomer(CustomerContactVO customerContactVO) {
        Map map=new HashMap();
        Customer customer=new Customer();
        customer.setId(customerContactVO.getCustomerId());
        customer.setDeleteStatus(customerContactVO.getDeleteStatus());
        customer.setIsLocked(customerContactVO.getIsLocked());
        if (customer.getId()==null){
            customer.setCreatorUserId(customerContactVO.getCustomerOwnerUserId());
        }else {
            customer.setCreatorUserId(customerContactVO.getCustomerCreatorUserId());
        }
        customer.setOwnerUserId(customerContactVO.getCustomerOwnerUserId());
        customer.setCustomerName(customerContactVO.getCustomerName());
        customer.setIndustry(customerContactVO.getIndustry());
        customer.setOrigin(customerContactVO.getOrigin());
        customer.setOwnership(customerContactVO.getOwnership());
        customer.setZipCode(customerContactVO.getZipCode());
        customer.setAnnualRevenue(customerContactVO.getAnnualRevenue());
        customer.setRating(customerContactVO.getRating());
        customer.setAddress(customerContactVO.getAddress());

        Contact contact=new Contact();
        contact.setId(customerContactVO.getContactId());
        contact.setCreatorUserId(customerContactVO.getContactCreatorUserId());
        contact.setName(customerContactVO.getContactName());
        contact.setSaltname(customerContactVO.getSaltname());
        contact.setEmail(customerContactVO.getEmail());
        contact.setPost(customerContactVO.getPost());
        contact.setQqNo(customerContactVO.getQqNo());
        contact.setTelephone(customerContactVO.getTelephone());
        contact.setDescription(customerContactVO.getDescription());

        boolean b = this.saveOrUpdate(customer);
        if (contact.getId()==null){
            contact.setCustomerId(customer.getId());
            contact.setCreatorUserId(customerContactVO.getCustomerOwnerUserId());
            contactMapper.insert(contact);
        }
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

    @Override
    public void deleteCustomer(int[] ids) {
        Map map=new HashMap();
        int c=0;
        for (int id : ids) {
            int i = baseMapper.deleteById(id);
            if (i==0){
                c++;
            }
        }
        if (c==0){
            map.put("msg","添加成功！");
            map.put("success",1);
        }else{
            map.put("msg","添加失败！");
            map.put("success",0);
        }
    }
}
