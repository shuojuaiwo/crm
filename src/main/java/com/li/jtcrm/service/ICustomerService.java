package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Customer;
import com.li.jtcrm.entity.vo.CustomerContactVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ICustomerService extends IService<Customer> {

    void toAddAndUpdateCustomer(Integer id, Model model);

    Map listCustomer(Integer page, Integer rows,String filterSearch,String search);

    Map addAndUpdateCustomer(CustomerContactVO customerContactVO,HttpSession session);

    void getCustomerInfo(Integer id, Model model);

    void deleteCustomer(int[] ids);

    Map listCustomerPool(Integer page, Integer rows,String filterSearch,String search);

    Map addAndUpdatePoolCustomer(CustomerContactVO customerContactVO, HttpSession session);

    Map selectByPageRecycle(Integer page, Integer rows,String filterSearch,String search);
    Map Recycleupdate(int[] id);
}
