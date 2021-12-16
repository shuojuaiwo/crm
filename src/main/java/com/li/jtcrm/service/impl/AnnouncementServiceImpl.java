package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.AnnouncementMapper;
import com.li.jtcrm.dao.UserMapper;
import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.entity.User;
import com.li.jtcrm.service.IAnnouncementService;
import com.li.jtcrm.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {


    public List<Announcement> selectfindpage(int page, int rows) {

        List<Announcement> selectfindall = baseMapper.selectfindall(page, rows);
        return selectfindall;
    }

}

