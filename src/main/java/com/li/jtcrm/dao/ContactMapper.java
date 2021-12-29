package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Contact;

import java.util.List;

public interface ContactMapper extends BaseMapper<Contact> {
    Contact selectContact(Integer id);
    List<Contact> selectName();
}
