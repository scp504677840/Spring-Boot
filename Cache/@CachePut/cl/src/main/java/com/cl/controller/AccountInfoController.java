package com.cl.controller;

import com.cl.entities.AccountInfo;
import com.cl.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    /**
     * 获取账户
     *
     * @return
     */
    @GetMapping("/getAccountInfo")
    public AccountInfo getAccountInfo() {
        return accountInfoService.getAccountInfoById(BigInteger.valueOf(3L));
    }

    /**
     * 更新账户
     *
     * @return
     */
    @GetMapping("/updateAccountInfo")
    public AccountInfo updateAccountInfo() {
        AccountInfo accountInfo = getAccountInfo();
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setBalance(accountInfo.getBalance().add(BigDecimal.ONE));
        return accountInfoService.updateAccountInfo(accountInfo);
    }

}
