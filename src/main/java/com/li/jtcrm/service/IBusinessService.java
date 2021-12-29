package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Business;
import org.springframework.ui.Model;

import java.util.Map;

public interface IBusinessService extends IService<Business> {

    Map listBusiness(Integer pagenum, Integer size);

    void toAddAndUpdateBusiness(Integer id,Model model);

    Map getBusinessStatus();

    Map getBusinessOrigin();

    Map getBusinessContact(Integer id);

    Map addAndUpdateBusiness(Business business);

    void getBusinessInfo(Integer id, Model model);
}
