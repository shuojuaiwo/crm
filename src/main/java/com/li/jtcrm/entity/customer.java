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
@TableName("tb_crm_customer")
public class customer {
    @TableId(value = "id")
    private String id;

    private String owner_user_id;

    private String creator_user_id;

    private String name;

    private String origin;

    private String address;

    private String zip_code;

    private String industry;

    private String annual_revenue;

    private String ownership;

    private String rating;

    private Date create_time;

    private Date update_time;

    private Integer delete_status;

    private Integer is_locked;

    private String delete_user_id;

    private Date delete_time;
}
