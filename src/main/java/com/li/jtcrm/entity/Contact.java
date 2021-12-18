package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_contact")
public class Contact implements Serializable {
    @TableId(value = "id")
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

    private LocalDate createTime;

    private LocalDate updateTime;

    private Integer deleteStatus;

    private Integer deleteUserId;

    private LocalDate deleteTime;
}
