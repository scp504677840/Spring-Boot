package com.db.controller;

import com.db.entities.AccountInfo;
import com.db.mapper.AccountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountInfoController {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @GetMapping("/getAccountInfo")
    public AccountInfo getAccountInfo() {
        return accountInfoMapper.getAccountInfoById(BigInteger.valueOf(3L));
    }

    @RequestMapping("/saveAccountInfo")
    public Map<String, Object> saveAccountInfo() {
        Map<String, Object> map = new HashMap<>();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom");
        accountInfo.setBalance(BigDecimal.valueOf(123456L));
        map.put("ok", accountInfoMapper.saveAccountInfo(accountInfo));
        return map;
    }

}
