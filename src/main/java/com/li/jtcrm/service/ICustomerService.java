package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Customer;

import java.util.Map;

public interface ICustomerService extends IService<Customer> {
    Map addCustomer(Customer customer);
}
