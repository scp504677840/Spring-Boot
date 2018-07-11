package com.cl.controller;

import com.cl.entities.AccountInfo;
import com.cl.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/getAccountInfo")
    public AccountInfo getAccountInfo() {
        return accountInfoService.getAccountInfoById(BigInteger.valueOf(3L));
    }

}
