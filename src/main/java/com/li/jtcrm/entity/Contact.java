package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_contact")
public class Contact implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer creatorUserId;

    private String name;

    private String post;

    private String department;

    private Integer sex;

    private String saltname;

    private String telephone;

    private String email;

    private String qqNo;

    private String address;

    private String zipCode;

    private String description;

    private Integer customerId;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private Integer deleteStatus;

    private Integer deleteUserId;

    private LocalDate deleteTime;
}
