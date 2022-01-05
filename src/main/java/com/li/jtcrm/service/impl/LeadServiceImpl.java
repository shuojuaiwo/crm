package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.LeadMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Lead;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.entity.vo.LeadVO;
import com.li.jtcrm.service.ILeadService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeadServiceImpl extends ServiceImpl<LeadMapper, Lead> implements ILeadService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Map listLead(Integer page, Integer rows,String filterSearch,String search) {
        Map map=new HashMap();
        Page<Object> page1 = new Page<>(page, rows);
        if (filterSearch!=null){
            if (filterSearch.equals("owner")){
                int cid = userMapper.selectid(search);
                search=String.valueOf(cid);
            }
        }
        List<LeadVO> vos = baseMapper.selectByPage(page1,filterSearch,search);
        for (LeadVO vo : vos) {
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
    public void toAddAndUpdateLead(Integer id, Model model) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List<User> users = userMapper.selectList(queryWrapper);
        model.addAttribute("users",users);
        if (id!=null){
            Lead lead = baseMapper.selectById(id);
            model.addAttribute("lead",lead);
        }
    }

    @Override
    public Map addAndUpdateLead(Lead lead, HttpSession session) {
        Map map=new HashMap();
        if (lead.getCreatorUserId()==null){
            lead.setCreatorUserId(((User) session.getAttribute("user1")).getId());
        }
        boolean b = this.saveOrUpdate(lead);
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
    public void getLeadInfo(Integer id, Model model) {
        Lead lead = baseMapper.selectById(id);
        model.addAttribute("lead",lead);
        String owner = userMapper.selectname(lead.getOwnerUserId());
        model.addAttribute("owner",owner);
    }

    @Override
    public void deleteLead(int[] ids,HttpSession session) {
        Map map=new HashMap();
        int c=0;
        for (int id : ids) {
            Date deleteTime = new Date();
            Integer deleteUserId = ((User) session.getAttribute("user1")).getId();
            int i = baseMapper.deleteId(id,deleteUserId,deleteTime);
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
    public Map listLeadPool(Integer page, Integer rows, String filterSearch, String search) {
        Map map=new HashMap();
        Page<Object> page1 = new Page<>(page, rows);
        List<LeadVO> vos = baseMapper.selectByPage1(page1,filterSearch,search);
        for (LeadVO vo : vos) {
            String createUser = userMapper.selectname(vo.getCreatorUserId());
            vo.setCreateUser(createUser);
        }
        map.put("total", page1.getTotal());
        map.put("rows", vos);
        return map;
    }

    @Override
    public Map selectByPageRecycle(Integer page, Integer rows, String filterSearch, String search) {
        Map map=new HashMap();
        Page<Object> page1 = new Page<>(page, rows);
        List<LeadVO> vos = baseMapper.selectByPageRecycle(page1,filterSearch,search);
        for (LeadVO vo : vos) {
            String createUser = userMapper.selectname(vo.getCreatorUserId());
            vo.setCreateUser(createUser);
        }
        map.put("total", page1.getTotal());
        map.put("rows", vos);
        return map;
    }

    public Map RecycleUpdate(int[] ids){
        Map map = new HashMap();
        for (Integer i :ids){
            baseMapper.RecycleUpdate(i);
        }
        map.put("success",1);
        map.put("msg","还原成功");
        return map;
    }
}
