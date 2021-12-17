package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
//@AllArgsConstructor
@TableName(value = "tb_crm_product")
public class Produce implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    private String name;
    private String link;
    private String username;
    private String creator_user_id;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createtime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDate updatetime;

    @TableField(value = "cost_price")
    private float costprice;
    @TableField(value = "suggested_price")
    private float suggestedprice;
}
