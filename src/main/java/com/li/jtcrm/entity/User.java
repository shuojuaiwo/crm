package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@TableName("tb_system_user")
public class User implements Serializable {
    @TableId(value = "id")
    private String id;

    private Date createTime;

    private String email;

    private String password;

    private String phone;

    private String salt;

    private Long sortNum;

    private Long status;

    private Date updateTime;

    private String userNote;

    private String username;

    private String createBy;

    private String updateBy;
}
