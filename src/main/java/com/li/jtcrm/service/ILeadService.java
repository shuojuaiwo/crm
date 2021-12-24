package com.li.jtcrm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.jtcrm.entity.Lead;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ILeadService extends IService<Lead> {

    void toAddAndUpdateLead(Integer id, Model model);

    Map listLead(Integer page, Integer rows,String filterSearch,String search);

    Map addAndUpdateLead(Lead lead, HttpSession session);

    //void getLeadInfo(Integer id, Model model);

    //void deleteLead(int[] ids);
}
