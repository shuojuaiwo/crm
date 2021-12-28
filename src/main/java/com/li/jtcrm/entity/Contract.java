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
    private Integer id;
    private String number;
    private String name;
    @TableField(value = "customer_name")
    private String customerName;
    private String username;
    @TableField(value = "due_time")
    private LocalDateTime dueTime;
    private BigDecimal price;
    private String status;
    @TableLogic
    private int state;
}
