package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.jtcrm.entity.Lead;
import com.li.jtcrm.entity.vo.LeadVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LeadMapper extends BaseMapper<Lead> {

    List<LeadVO> selectByPage(Page<?> page, @Param("filterSearch") String filterSearch, @Param("search") String search);

    List<LeadVO> selectByPage1(Page<?> page, @Param("filterSearch")String filterSearch, @Param("search") String search);


    int deleteId(int id,@Param("deleteUserId") Integer deleteUserId,@Param("deleteTime") Date deleteTime);

    List<LeadVO> selectByPageRecycle(Page<?> page,@Param("filterSearch") String filterSearch,@Param("search") String search);

    void RecycleUpdate(Integer id);
}
