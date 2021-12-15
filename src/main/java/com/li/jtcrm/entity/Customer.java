package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_customer")
public class Customer {
    @TableId(value = "id")
    private String id;

    private String ownerUserId;

    private String creatorUserId;

    private String name;

    private String origin;

    private String address;

    private String zipCode;

    private String industry;

    private String annualRevenue;

    private String ownership;

    private String rating;

    private Date createTime;

    private Date updateTime;

    private Integer deleteStatus;

    private Integer isLocked;

    private String deleteUserId;

    private Date deleteTime;
}
