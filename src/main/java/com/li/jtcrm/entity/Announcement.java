package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private LocalDate update_time;
    private int status;
    private int isshow;
//
//    public Announcement(String name, String username, String title, String content, Date update_time, int status) {
//        this.name = name;
//        this.username = username;
//        this.title = title;
//        this.content = content;
//        this.update_time = update_time;
//        this.status = status;
//    }
//
//    public Announcement(int id, String name, String username, String title, String content, Date update_time, int status) {
//        this.id = id;
//        this.name = name;
//        this.username = username;
//        this.title = title;
//        this.content = content;
//        this.update_time = update_time;
//        this.status = status;
//    }
//
//    public Announcement(int id, String name, int user_id, String username, String title, String content, Date update_time, int status, int isshow) {
//        this.id = id;
//        this.name = name;
//        this.user_id = user_id;
//        this.username = username;
//        this.title = title;
//        this.content = content;
//        this.update_time = update_time;
//        this.status = status;
//        this.isshow = isshow;
//    }
}
