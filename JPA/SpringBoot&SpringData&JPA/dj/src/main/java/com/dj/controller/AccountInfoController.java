package com.dj.controller;

import com.dj.entities.AccountInfoEntity;
import com.dj.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/show")
    public AccountInfoEntity getAccountInfo() {
        AccountInfoEntity entity = accountInfoService.getAccountInfoById(BigInteger.valueOf(3L));
        System.out.println(entity);
        return entity;
    }

}