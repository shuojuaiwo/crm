package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_customer")
public class Customer implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer ownerUserId;

    private Integer creatorUserId;

    private String customerName;

    private String origin;

    private String address;

    private String zipCode;

    private String industry;

    private String annualRevenue;

    private String ownership;

    private String rating;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private Integer deleteStatus;

    private Integer isLocked;

    private Integer deleteUserId;

    private Date deleteTime;

}
