package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.vo.CustomerContactVO;
import org.springframework.ui.Model;

import java.util.Map;

public interface ICustomerService extends IService<Customer> {

    void toAddAndUpdateCustomer(Integer id, Model model);

    Map listCustomer(Integer page, Integer rows,String filterSearch,String search);

    Map addAndUpdateCustomer(CustomerContactVO customerContactVO);

    void getCustomerInfo(Integer id, Model model);

    void deleteCustomer(int[] ids);
}
