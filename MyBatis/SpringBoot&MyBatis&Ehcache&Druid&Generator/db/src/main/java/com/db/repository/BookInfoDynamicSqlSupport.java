package com.db.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.JDBCType;
import java.sql.Timestamp;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.processing.Generated;

public final class BookInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.928717+08:00", comments="Source Table: book_info")
    public static final BookInfo bookInfo = new BookInfo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.929492+08:00", comments="Source field: book_info.id")
    public static final SqlColumn<BigInteger> id = bookInfo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.93018+08:00", comments="Source field: book_info.gmt_create")
    public static final SqlColumn<Timestamp> gmtCreate = bookInfo.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.930446+08:00", comments="Source field: book_info.gmt_modified")
    public static final SqlColumn<Timestamp> gmtModified = bookInfo.gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.930607+08:00", comments="Source field: book_info.name")
    public static final SqlColumn<String> name = bookInfo.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.930826+08:00", comments="Source field: book_info.price")
    public static final SqlColumn<BigDecimal> price = bookInfo.price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-11T14:32:24.929274+08:00", comments="Source Table: book_info")
    public static final class BookInfo extends SqlTable {
        public final SqlColumn<BigInteger> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Timestamp> gmtCreate = column("gmt_create", JDBCType.TIMESTAMP);

        public final SqlColumn<Timestamp> gmtModified = column("gmt_modified", JDBCType.TIMESTAMP);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> price = column("price", JDBCType.DECIMAL);

        public BookInfo() {
            super("book_info");
        }
    }
}