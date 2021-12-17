package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ProduceMapper;
import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.IProduceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceServiceImpl extends ServiceImpl<ProduceMapper, Produce> implements IProduceService {


    public List<Produce> ProduceAllPage(int page, int rows) {
        List<Produce> Producefindall = baseMapper.ProduceAll(page,rows);
        return Producefindall;
    }

//    public void Produceadd(String id, String name, String creator_user_id, String link, float cost_price, float suggested_price ,String create_time,String update_time){
//        baseMapper.ProduceAdd(id,name,creator_user_id,link,cost_price,suggested_price,create_time,update_time);
//    }

}

