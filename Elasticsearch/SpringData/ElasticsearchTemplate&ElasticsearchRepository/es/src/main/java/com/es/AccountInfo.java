package com.es;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * -- auto-generated definition
 * create table account_info
 * (
 * id           bigint unsigned auto_increment,
 * gmt_create   datetime                not null,
 * gmt_modified datetime                not null,
 * name         varchar(30)             not null,
 * balance      decimal(10, 2) unsigned not null,
 * constraint account_info_id_uindex
 * unique (id)
 * );
 * <p>
 * alter table account_info
 * add primary key (id);
 */
@Document(indexName = "lab",type = "accountInfo")
public class AccountInfo implements Serializable {

    /**
     * 注解@JestId标记elasticsearch文档主键ID
     * 此注解适用于Jest。
     * 不适用于SpringData。
     */
    //@JestId
    private Long id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String name;
    private BigDecimal balance;

    public AccountInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}