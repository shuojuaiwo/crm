package com.li.jtcrm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@TableName(value = "tb_crm_product")
public class Produce {
    private String name;
    private String link;
    private String username;
    private Timestamp create_time;
    private Timestamp update_time;
    private float cost_price;
    private float suggested_price;

    public Produce(String link, String username, Timestamp create_time, Timestamp update_time, float cost_price, float suggested_price) {
        this.link = link;
        this.username = username;
        this.create_time = create_time;
        this.update_time = update_time;
        this.cost_price = cost_price;
        this.suggested_price = suggested_price;
    }

    public Produce(String name, String link, String username, Timestamp create_time, Timestamp update_time, float cost_price, float suggested_price) {
        this.name = name;
        this.link = link;
        this.username = username;
        this.create_time = create_time;
        this.update_time = update_time;
        this.cost_price = cost_price;
        this.suggested_price = suggested_price;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", username='" + username + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", cost_price=" + cost_price +
                ", suggested_price=" + suggested_price +
                '}';
    }
}
