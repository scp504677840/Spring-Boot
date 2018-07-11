package com.db.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * -- auto-generated definition
 * create table shop_info
 * (
 * id           bigint unsigned auto_increment,
 * gmt_create   datetime    not null,
 * gmt_modified datetime    not null,
 * name         varchar(30) not null,
 * constraint shop_info_id_uindex
 * unique (id)
 * );
 * <p>
 * alter table shop_info
 * add primary key (id);
 */
public class ShopInfo implements Serializable {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String name;

    public ShopInfo() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                '}';
    }
}
