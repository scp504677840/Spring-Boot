package com.dj.repository;

import com.dj.entities.AccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, BigInteger> {

    AccountInfoEntity getAccountInfoEntityById(BigInteger id);

}