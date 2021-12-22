package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Alias("user")
@Component
@Data
@NoArgsConstructor
@TableName("tb_system_user")
public class User implements Serializable {
    @TableId(value = "id")
    private Integer id;

    private Date createTime;

    private String email;

    private String password;

    private String phone;

    private String salt;

    private Integer sortNum;
    private Integer status;

    private Date updateTime;

    private String userNote;

    private String username;

    private String createBy;

    private String updateBy;
}
