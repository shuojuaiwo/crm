package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ProduceMapper;
import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.IProduceService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProduceServiceImpl extends ServiceImpl<ProduceMapper, Produce> implements IProduceService {


    public List<Produce> ProduceAllPage(int page, int rows) {
        List<Produce> Producefindall = baseMapper.ProduceAll(page,rows);
        return Producefindall;
    }

    public Map Delete(int[] ids){
        Map map=new HashMap();
        for(int i : ids){
            baseMapper.deleteById(i);
        }
        map.put("success",1);
        map.put("message","删除成功");
        return map;
    }

    public Produce show(int id){
        Produce produce = baseMapper.ProduceShow(id);
        return produce;
    }

    public List<Produce> mohu(String name, float suggested_price){
        return baseMapper.mohucha(name,suggested_price);
    }

}

