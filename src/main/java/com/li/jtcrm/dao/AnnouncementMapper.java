package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Announcement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnouncementMapper extends BaseMapper<Announcement> {
    //分页
    List<Announcement> SelectFindAll(@Param("page") int page,@Param("rows") int rows,@Param("title") String title,@Param("name") String name);
    //修改
    Announcement SelectAll(@Param("id") int id);
    //查看详情
    Announcement SelectInfo (@Param("id") int id);


}
