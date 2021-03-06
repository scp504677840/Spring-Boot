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
import java.util.HashMap;
import java.util.Map;

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
        return accountInfoService.getAccountInfoById(BigInteger.valueOf(11L));
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

    /**
     * 删除账户
     *
     * @return
     */
    @GetMapping("/deleteAccountInfo")
    public Map<String,Object> deleteAccountInfo(){
        Map<String,Object> result = new HashMap<>();
        result.put("ok",accountInfoService.deleteAccountInfo(BigInteger.valueOf(11L)));
        return result;
    }

}
