package com.li.jtcrm.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LeadVO {
    private Integer id;
    private Integer deleteStatus;
    private Integer isTransformed;
    private String name;
    private String source;
    private String contactName;
    private String position;
    private String saltname;
    private String mobile;
    private String email;
    private String address;
    private LocalDate nextstepTime;
    private String nextstep;
    private Integer ownerUserId;
    private Integer creatorUserId;
    private String ownerUser;
    private String createUser;
    private LocalDate createTime;
    private Integer days;
}
