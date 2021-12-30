package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.BusinessMapper;
import com.li.jtcrm.dao.ContactMapper;
import com.li.jtcrm.dao.CustomerMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.*;
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

    @Resource
    private ContactMapper contactMapper;

    @Override
    public Map listBusiness(Integer page,Integer rows,String searchBy,String searchText) {
        Map map=new HashMap();
        Page<Object> page1 = new Page<>(page, rows);
        if (searchBy!=null){
            if (searchBy.equals("customer_name")){
                int cid = customerMapper.selectid(searchText);
                searchText=String.valueOf(cid);
            }
        }
        List<BusinessVO> vos = baseMapper.selectByPage(page1,searchBy,searchText);
        for (BusinessVO vo : vos) {
            String customerName = customerMapper.selectname(vo.getCustomerId());
            vo.setCustomerName(customerName);
            String ownerUser = userMapper.selectname(vo.getOwnerUserId());
            String createUser = userMapper.selectname(vo.getCreatorUserId());
            vo.setOwnerUser(ownerUser);
            vo.setCreateUser(createUser);
        }
        map.put("total", page1.getTotal());
        map.put("rows", vos);
        return map;
    }

    @Override
    public void toAddAndUpdateBusiness(Integer id,Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(queryWrapper);
        model.addAttribute("users",users);
        QueryWrapper<Customer> queryWrapper1 = new QueryWrapper<Customer>();
        List<Customer> customers = customerMapper.selectList(queryWrapper1);
        model.addAttribute("customers",customers);
        if (id!=null){
            Business business = baseMapper.selectById(id);
            model.addAttribute("business",business);
            String contactName = contactMapper.selectname(business.getContactId());
            model.addAttribute("contactName",contactName);
        }
    }

    @Override
    public Map addAndUpdateBusiness(Business business) {
        Map map=new HashMap();
        boolean b = saveOrUpdate(business);
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
    public void getBusinessInfo(Integer id, Model model) {
        Business business = baseMapper.selectById(id);
        System.out.println(business);
        model.addAttribute("business",business);
        String owner = userMapper.selectname(business.getOwnerUserId());
        model.addAttribute("owner",owner);
        String customerName = customerMapper.selectname(business.getCustomerId());
        model.addAttribute("customerName",customerName);
        String contactName = contactMapper.selectname(business.getContactId());
        model.addAttribute("contactName",contactName);
        String statusName = baseMapper.selectStatusName(business.getStatusId());
        model.addAttribute("statusName",statusName);
    }

    @Override
    public void deleteBusiness(int[] ids) {
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

    @Override
    public Map getBusinessStatus() {
        Map map=new HashMap();
        List<BusinessStatus> statuses = baseMapper.selectStatus();
        map.put("data",statuses);
        return map;
    }

    @Override
    public Map getBusinessOrigin() {
        Map map=new HashMap();
        List<String> strings = baseMapper.selectOrigin();
        map.put("data",strings);
        return map;
    }

    @Override
    public Map getBusinessContact(Integer id) {
        Map map=new HashMap();
        List<Contact> contacts = contactMapper.selectc(id);
        map.put("data",contacts);
        return map;
    }

    public List<BusinessVO> selectoriginl(Model model){
        List<BusinessVO> selectorigin = baseMapper.selectorigin();
        model.addAttribute("laiy",selectorigin);
        return selectorigin;
    }
}
