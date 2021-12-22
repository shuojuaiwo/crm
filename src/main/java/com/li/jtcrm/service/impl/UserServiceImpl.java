package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    public Map selectByname(String username, String password,String remember_me, HttpSession session){
        Map map=new HashMap();
        User user=null;
        user = baseMapper.selectByname(username);
        List<User> users = baseMapper.selectFindAll();
        if (user==null){
            map.put("success",0);
            map.put("msg","账号或密码错误");
        }else {
            if (username.equals(user.getUsername())&&password.equals(user.getPassword())){
                if (remember_me != null) {
                    session.setAttribute("user1",user);
                }
                if (user.getStatus()==1){
                    map.put("success",1);
                    map.put("msg","登入成功");
                    session.setAttribute("users",users);
                    session.setAttribute("user",user);
                }else {
                    map.put("success",0);
                    map.put("msg","您没有权限登入,请联系管理员");
                }
            }else{
                map.put("success",0);
                map.put("msg","账号或密码错误");
            }
        }
        return map;
    }

    public Map Muen(String username){
        Map map=new HashMap();
//        User user = (User) session.getAttribute("user");
        Map<String, Object> muenqx = baseMapper.Muenqx(username);
        int roleId =(int) muenqx.get("roleId");
        List<Object> muendz = baseMapper.Muendz(roleId);
        map.put("data",muendz);
        map.put("success",true);
        return map;
    }
}
