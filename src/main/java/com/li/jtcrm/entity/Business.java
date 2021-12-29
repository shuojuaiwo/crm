package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_business")
public class Business implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String origin;
    private String type;
    private Integer estimatePrice;
    private Integer customerId;
    private Integer creatorUserId;
    private Integer ownerUserId;
    private Integer gainRate;
    private Integer totalAmount;
    private Float subtotalVal;
    private Float discountPrice;
    private Float salesPrice;
    private LocalDate dueDate;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    private Integer updateUserId;
    private Integer statusId;
    private Float totalPrice;
    private String nextstep;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate nextstepTime;
    private Integer deleteStatus;
    private Integer deleteUserId;
    private LocalDate deleteTime;
    private Integer contactId;
    private String contractAddress;
    private String description;
}
