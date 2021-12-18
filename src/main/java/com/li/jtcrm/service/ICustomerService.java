package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Customer;
import org.springframework.ui.Model;

import java.util.Map;

public interface ICustomerService extends IService<Customer> {
    Map addCustomer(Customer customer);

    Map listCustomer(Integer pagenum, Integer size);

    void toAddCustomer(Model model);

    void getCustomerInfo(Integer id, Model model);
}
