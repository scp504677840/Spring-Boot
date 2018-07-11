package com.dj.service.impl;

import com.dj.entities.AccountInfoEntity;
import com.dj.repository.AccountInfoRepository;
import com.dj.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("accountInfoService")
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    /**
     * 根据账户Id
     *
     * @param id 账户Id
     * @return 账户信息
     */
    @Override
    public AccountInfoEntity getAccountInfoById(BigInteger id) {
        return accountInfoRepository.getAccountInfoEntityById(id);
    }
}