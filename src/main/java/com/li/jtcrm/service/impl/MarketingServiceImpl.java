package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.MarketingMapper;
import com.li.jtcrm.entity.Record;
import com.li.jtcrm.service.IMarketingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MarketingServiceImpl extends ServiceImpl<MarketingMapper, Record> implements IMarketingService {
public Map maretingAll(String searchBy,String contain,String text){
    Map map= new HashMap();
    List<Record> maretingall = baseMapper.maretingall(searchBy, contain, text);
    map.put("rows",maretingall);
    return map;
}

    public Map Maretingdel(int[] ids){
    Map map = new HashMap();
    for (int i:ids){
        baseMapper.deleteById(i);
    }
    map.put("success",1);
    map.put("message","删除成功");
    return map;
    }
}
