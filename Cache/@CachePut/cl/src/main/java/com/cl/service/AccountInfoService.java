package com.cl.service;

import com.cl.entities.AccountInfo;
import com.cl.mapper.AccountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    /**
     * 注解@Cacheable：可缓存的。
     * value：缓存的名称
     * key：支持SpEl表达式
     * keyGenerator：key的生成器，可以指定key的生成器的组件Id。
     * key和keyGenerator二选一即可。
     * <p>
     * cacheManager：缓存管理器。
     * cacheResolver：缓存解析器。
     * cacheManager和cacheResolver二选一即可。
     * <p>
     * condition：指定条件。支持SpEL表达式。条件满足则缓存，否则不缓存。如：condition = "#id > 0"
     * unless：否定缓存；当值为false时不缓存。如：unless = "#result == null "，当结果为null时不缓存。
     * sync：是否使用异步模式。
     *
     * @param id 账户Id
     * @return
     */
    @Cacheable(value = "accountInfo", key = "#id", unless = "#result == null ")
    public AccountInfo getAccountInfoById(BigInteger id) {
        return accountInfoMapper.getAccountInfo(id);
    }

    /**
     * 注解@CachePut：更新缓存
     *
     * @param accountInfo 账户信息
     * @return
     */
    @CachePut(value = "accountInfo", key = "#accountInfo.id", unless = "#accountInfo == null ")
    public AccountInfo updateAccountInfo(AccountInfo accountInfo) {
        Boolean update = accountInfoMapper.updateAccountInfo(accountInfo);
        System.out.println(update);
        return accountInfo;
    }

}
