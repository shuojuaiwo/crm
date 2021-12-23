package com.li.jtcrm.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerVO {
    private Integer id;
    private String customerName;
    private String industry;
    private String rating;
    private String address;
    private Integer ownerUserId;
    private Integer creatorUserId;
    private String ownerUser;
    private String createUser;
    private LocalDate createTime;
    private LocalDate updateTime;
}
