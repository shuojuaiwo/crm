package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.TaskMapper;
import com.li.jtcrm.entity.Task;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {
    public Map TaskFindPageAll(Integer page,Integer rows,String zhuang,String subject){
        Map map=new HashMap<>();
        List<Task> tasks = baseMapper.TaskFindAll(page, rows,zhuang,subject);
        for (Task task : tasks){
            System.out.println(task.getOwnerUserId());
            User user = baseMapper.TaskId(task.getOwnerUserId());
            task.setName(user.getUsername());
            User user1 = baseMapper.TaskId(task.getCreatorUserId());
            task.setUsername(user1.getUsername());
        }
        map.put("rows",tasks);
        return map;
    }

}

