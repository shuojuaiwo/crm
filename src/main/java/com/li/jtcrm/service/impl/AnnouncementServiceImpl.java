package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.AnnouncementMapper;
import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.service.IAnnouncementService;
import org.springframework.stereotype.Service;
import java.util.List;

//服务层写
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {
    //分页功能
    public List<Announcement> SelectFindPage(int page, int rows) {
        //查到的数据放入到对象中
        List<Announcement> SelectFindAll = baseMapper.SelectFindAll(page, rows);
        return SelectFindAll;
    }

    //修改功能实现
//    public Announcement selectById(int id){
//        return baseMapper.selectById(id);
//    }

}

