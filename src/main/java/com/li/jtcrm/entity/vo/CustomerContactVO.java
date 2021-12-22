package com.li.jtcrm.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerContactVO {
    private Integer customerId;
    private Integer deleteStatus;
    private Integer isLocked;
    private Integer contactId;
    private Integer contactCreatorUserId;
    //private LocalDate contactCreateTime;
    private Integer customerCreatorUserId;
    //private LocalDate customerCreateTime;
    private Integer customerOwnerUserId;
    private String customerName;
    private String industry;
    private String origin;
    private String ownership;
    private String zipCode;
    private String annualRevenue;
    private String rating;
    private String address;
    private String contactName;
    private String saltname;
    private String email;
    private String post;
    private String qqNo;
    private String telephone;
    private String description;

}
