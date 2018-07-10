package com.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbApplicationTests {

    //测试1：DataSource
    /*@Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    //测试2：JdbcTemplate，JdbcTemplate是SpringBoot默认已经注入好的Bean。
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        String sql = "select id,gmt_create gmtCreate,gmt_modified gmtModified,name,balance from account_info where id = ?";
        RowMapper<AccountInfo> rm = new BeanPropertyRowMapper<>(AccountInfo.class);
        List<AccountInfo> accountInfoList = jdbcTemplate.query(sql, rm, 1);
        accountInfoList.forEach(System.out::println);
    }

}
