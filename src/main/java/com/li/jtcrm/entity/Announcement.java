package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("tb_crm_announcement")
public class Announcement {
    private String id;
    private String name;
    private String username;
    private String title;
    private String content;
    private Date update_time;
    private int status;



    public Announcement() {
    }

    public Announcement(String name, String username, String title, String content, Date update_time, int status) {
        this.name = name;
        this.username = username;
        this.title = title;
        this.content = content;
        this.update_time = update_time;
        this.status = status;
    }

    public Announcement(String id, String name, String username, String title, String content, Date update_time, int status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.title = title;
        this.content = content;
        this.update_time = update_time;
        this.status = status;
    }
}
