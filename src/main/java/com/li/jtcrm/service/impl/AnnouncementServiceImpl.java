package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.AnnouncementMapper;
import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.service.IAnnouncementService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//服务层写
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {
    //分页功能
    public List<Announcement> SelectFindPage(int page, int rows,String title,String name) {
        //查到的数据放入到对象中
        List<Announcement> SelectFindAll = baseMapper.SelectFindAll(page, rows,title, name);
        return SelectFindAll;
    }

    //修改功能实现
    public Announcement selectById(int id){
        return baseMapper.SelectAll(id);
    }

    //删除功能实现
    public Map delete(int[] ids){
        Map map = new HashMap();
        for(int id:ids){
          baseMapper.deleteById(id);
        }
        map.put("success",1);
        map.put("message","删除成功");
        return map;
    }

    //查看详情功能实现
    public Announcement selectinfo(int id){
        Announcement announcement = baseMapper.SelectInfo(id);
        return announcement;

    }

}

