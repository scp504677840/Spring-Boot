package com.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountInfoController {

    /**
     * JdbcTemplate是SpringBoot默认已经注入好的Bean。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/getAccountInfo")
    public AccountInfo getAccountInfo() {
        String sql = "select id,gmt_create gmtCreate,gmt_modified gmtModified,name,balance from account_info where id = ?";
        RowMapper<AccountInfo> rm = new BeanPropertyRowMapper<>(AccountInfo.class);
        List<AccountInfo> accountInfoList = jdbcTemplate.query(sql, rm, 1);
        accountInfoList.forEach(System.out::println);
        return accountInfoList.get(0);
    }

}
