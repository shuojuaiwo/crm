package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName("tb_crm_contract")
public class Contract implements Serializable {
    @TableId(value = "id")
    private int id;
    private String number;
    private String name;
    private String name1;
    @TableField(value = "customer_name")
    private String customerName;
    private String username;
    @TableField(value = "due_time")
    private String dueTime;
    private BigDecimal price;
    private String status;
    @TableLogic
    private int state;
    @TableField(value = "business_id")
    private int businessId;
    @TableField(value = "owner_user_id")
    private int ownerUserId;
    @TableField(value = "start_date")
    private String startDate;
    @TableField(value = "end_date")
    private String endDate;
    private String endd;
    private String content;
    private String description;
}
