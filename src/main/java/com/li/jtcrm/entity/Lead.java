package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_lead")
public class Lead implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer ownerUserId;
    private Integer creatorUserId;
    private String name;
    private String position;
    private String contactName;
    private String saltname;
    private String mobile;
    private String email;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    private Integer deleteStatus;
    private Integer deleteUserId;
    private Date deleteTime;
    private Integer isTransformed;
    private Integer transformUserId;
    private Integer contactId;
    private Integer customerId;
    private Integer businessId;
    private String nextstep;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate nextstepTime;
    private Date haveTime;
    private String address;
    private String source;
    private String leadnote;
}
