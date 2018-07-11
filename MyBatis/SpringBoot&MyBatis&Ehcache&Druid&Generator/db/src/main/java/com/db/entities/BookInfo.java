package com.db.entities;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class BookInfo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.916835+08:00", comments="Source field: book_info.id")
    private BigInteger id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.921416+08:00", comments="Source field: book_info.gmt_create")
    private Timestamp gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.921913+08:00", comments="Source field: book_info.gmt_modified")
    private Timestamp gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.922387+08:00", comments="Source field: book_info.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.92293+08:00", comments="Source field: book_info.price")
    private BigDecimal price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.920137+08:00", comments="Source field: book_info.id")
    public BigInteger getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.921214+08:00", comments="Source field: book_info.id")
    public void setId(BigInteger id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.921594+08:00", comments="Source field: book_info.gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.921759+08:00", comments="Source field: book_info.gmt_create")
    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.92208+08:00", comments="Source field: book_info.gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.922239+08:00", comments="Source field: book_info.gmt_modified")
    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.922542+08:00", comments="Source field: book_info.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.922762+08:00", comments="Source field: book_info.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.923099+08:00", comments="Source field: book_info.price")
    public BigDecimal getPrice() {
        return price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.923268+08:00", comments="Source field: book_info.price")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}