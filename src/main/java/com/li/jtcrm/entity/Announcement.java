package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_announcement")
public class Announcement {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String name;
    private int user_id;
    private int order_id;
    private  int department;
    private String color;
    private String username;
    private String title;
    private String content;
    @TableField(value = "update_time" )
    private LocalDate updatetime;
    private int status;
    private int isshow;

    //假删注解
    @TableLogic
    private int state;
}
