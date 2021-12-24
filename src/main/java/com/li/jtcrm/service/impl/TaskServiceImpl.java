package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.TaskMapper;
import com.li.jtcrm.entity.Task;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {
    public Map TaskFindPageAll(Integer page,Integer rows,String zhuang,String subject){
        Map map=new HashMap<>();
        int count = baseMapper.selectCount(new QueryWrapper<Task>());
        List<Task> tasks = baseMapper.TaskFindAll(page, rows,zhuang,subject);
        for (Task task : tasks){
            System.out.println(task.getOwnerUserId());
            User user = baseMapper.TaskId(task.getOwnerUserId());
            task.setName(user.getUsername());
            User user1 = baseMapper.TaskId(task.getCreatorUserId());
            task.setUsername(user1.getUsername());
        }
        map.put("rows",tasks);
        map.put("total",count);
        return map;
    }

    public Map TaskDelete(int[] ids){
        Map map=new HashMap();
        for (int i:ids){
            baseMapper.deleteById(i);
        }
        map.put("success",1);
        map.put("message","删除成功");

        return map;
    }

    public Task TaskInfoById(int id){
        Task taskinfo = baseMapper.taskinfo(id);
        User user =baseMapper.TaskId(taskinfo.getCreatorUserId());
        User user1=baseMapper.TaskId(taskinfo.getOwnerUserId());
        taskinfo.setName(user.getUsername());
        taskinfo.setUsername(user1.getUsername());
        return taskinfo;
    }

}

