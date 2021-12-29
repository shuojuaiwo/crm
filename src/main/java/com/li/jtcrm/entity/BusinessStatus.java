package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@TableName("tb_crm_business_status")
public class BusinessStatus implements Serializable {
    @TableId(value = "id")
    private Integer id;
    private String name;
}
