package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Announcement;
import com.li.jtcrm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnouncementMapper extends BaseMapper<Announcement> {
    List<Announcement> selectfindall(@Param("page") int page,@Param("rows") int rows);
}
