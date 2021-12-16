package com.li.jtcrm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.jtcrm.dao.ProduceMapper;
import com.li.jtcrm.entity.Produce;
import com.li.jtcrm.service.IProduceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceServiceImpl extends ServiceImpl<ProduceMapper, Produce> implements IProduceService {


    public List<Produce> ProduceAllPage(int page, int rows) {
        List<Produce> Producefindall = baseMapper.ProduceAll(page,rows);
        return Producefindall;
    }

}

