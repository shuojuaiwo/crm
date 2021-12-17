package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@TableName(value = "tb_crm_product")
@ToString
public class Produce {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    private String link;
    private String username;
    private String creator_user_id;
    @TableField(fill = FieldFill.INSERT)
    private LocalDate create_time;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDate update_time;


    private float cost_price;
    private float suggested_price;

    public Produce(String id, String name, String link, String creator_user_id, LocalDate create_time, LocalDate update_time, float cost_price) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.creator_user_id = creator_user_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.cost_price = cost_price;
    }

    public Produce(String name, String link, String username, String creator_user_id, LocalDate create_time, LocalDate update_time, float cost_price, float suggested_price) {
        this.name = name;
        this.link = link;
        this.username = username;
        this.creator_user_id = creator_user_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.cost_price = cost_price;
        this.suggested_price = suggested_price;
    }



    public Produce(String id, String name, String link, String username, String creator_user_id, LocalDate create_time, LocalDate update_time, float cost_price, float suggested_price) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.username = username;
        this.creator_user_id = creator_user_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.cost_price = cost_price;
        this.suggested_price = suggested_price;
    }


}
