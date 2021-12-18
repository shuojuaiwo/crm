package com.li.jtcrm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.jtcrm.entity.Contact;

public interface ContactMapper extends BaseMapper<Contact> {
    Contact selectContact(Integer id);
}
