package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@TableName(value = "tb_crm_task")
public class Task{
    public Task(){
        super();
    }
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "owner_user_id")
    private Integer ownerUserId;

    private String username;
    private String name;
    @TableField(value = "about_users")
    private String aboutusers;
    private String subject;
    @TableField(value = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date duedate;
    private String status;
    private String priority;
    private String send_email;
    private String description;
    @TableField(value = "creator_user_id")
    private int creatorUserId;
    @TableField(value = "create_date")
    private LocalDateTime createdate;
    @TableField(value = "update_date")
    private LocalDateTime updatedate;
    private Integer isclose;
    private Integer delete_status;
    private Integer delete_user_id;
    @TableField(value = "delete_time")
    private LocalDateTime deletetime;

}
