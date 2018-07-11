package com.cl.mapper;

import com.cl.entities.AccountInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;

public interface AccountInfoMapper {

    @Select("select * from account_info where id = #{id}")
    AccountInfo getAccountInfo(BigInteger id);

}
