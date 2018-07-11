package com.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
            System.out.println(dataSource.getClass());
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*
    {
	    CreateTime:"2018-07-11 00:51:52",
	    ActiveCount:0,
	    PoolingCount:0,
	    CreateCount:0,
	    DestroyCount:0,
	    CloseCount:0,
	    ConnectCount:0,
	    Connections:[
	    ]
    }
     */

    //测试2：JdbcTemplate，JdbcTemplate是SpringBoot默认已经注入好的Bean。
    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        String sql = "select id,gmt_create gmtCreate,gmt_modified gmtModified,name,balance from account_info where id = ?";
        RowMapper<AccountInfo> rm = new BeanPropertyRowMapper<>(AccountInfo.class);
        List<AccountInfo> accountInfoList = jdbcTemplate.query(sql, rm, 1);
        accountInfoList.forEach(System.out::println);
    }*/

    /**
     * 测试：自动生成Mapper
     */
    @Test
    public void contextLoads() {
        try {
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            File configFile = new File("mbg.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException | SQLException | InterruptedException | XMLParserException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
