package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Business;
import org.springframework.ui.Model;

import java.util.Map;

public interface IBusinessService extends IService<Business> {

    void toAddAndUpdateBusiness(Integer id,Model model);

    void deleteBusiness(int[] ids);

    Map getBusinessStatus();

    Map getBusinessOrigin();

    Map getBusinessContact(Integer id);

    Map addAndUpdateBusiness(Business business);

    void getBusinessInfo(Integer id, Model model);

    Map listBusiness(Integer page, Integer rows, String searchBy, String searchText);
}
