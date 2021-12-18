package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Business;

import java.util.Map;

public interface IBusinessService extends IService<Business> {

    Map listBusiness(Integer pagenum, Integer size);
}
