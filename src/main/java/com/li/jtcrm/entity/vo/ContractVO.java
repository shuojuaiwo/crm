package com.li.jtcrm.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("tb_crm_r_business_contract")
public class ContractVO {
    @TableId(value = "id")
    private int id;
    @TableField(value = "business_id")
    private int businessId;
    @TableField(value = "contract_id")
    private int contractId;

}
