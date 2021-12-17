package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@NoArgsConstructor
@TableName("tb_system_role")
public class Role {
    @TableId(value = "id")
    private Integer id;

    private Date createTime;

    private String roleName;

    private String roleNote;

    private Integer sortNum;

    private Integer status;

    private Date updateTime;

    private String createBy;

    private String updateBy;
}
