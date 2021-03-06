package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.vo.CustomerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends BaseMapper<Customer> {

    List<CustomerVO> selectByPage(Page<?> page,@Param("filterSearch") String filterSearch,@Param("search") String search);

    String selectname(Integer id);

    List<CustomerVO> selectbyName();

    int selectid(@Param("searchText") String searchText);

    List<CustomerVO> selectByPagePool(Page<?> page,@Param("filterSearch") String filterSearch,@Param("search") String search);

    List<CustomerVO> selectByPageRecycle(Page<?> page,@Param("filterSearch") String filterSearch,@Param("search") String search);

    Map Recycleupdate(@Param("id") Integer id);
}
