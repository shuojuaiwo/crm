package com.li.jtcrm.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BusinessVO {
    private Integer id;
    private Integer customerId;
    private String customerName;
    private String name;
    private String origin;
    private LocalDate nextstepTime;
    private String nextstep;
    private Integer ownerUserId;
    private Integer creatorUserId;
    private String ownerUser;
    private String createUser;
    private LocalDate createTime;
    private LocalDate updateTime;
}
