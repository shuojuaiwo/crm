package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("tb_crm_sms_record")
public class Record {
    @TableId(value = "id")
    private int id;
    @TableField(value = "user_id")
    private int userId;
    @TableField(value = "telephone")
    private String phone;
    private String username;
    private String telephone;
    private String content;
    @TableField(value = "sendtime",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private LocalDateTime sendtime;

    @TableLogic
    private int state;
}
