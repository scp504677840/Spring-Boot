package com.db.mapper;

import com.db.entities.AccountInfo;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;

//@Mapper
public interface AccountInfoMapper {

    @Select("select * from account_info where id = #{id}")
    AccountInfo getAccountInfoById(BigInteger id);

    @Insert("insert into account_info(gmt_create, gmt_modified, name, balance) values (#{gmtCreate},#{gmtModified},#{name},#{balance})")
    Boolean saveAccountInfo(AccountInfo accountInfo);

    @Update("update account_info set gmt_modified = #{gmtModified},name = #{name},balance = #{balance} where id = #{id}")
    Boolean updateAccountInfo(AccountInfo accountInfo);

    @Delete("delete from account_info where id = #{id}")
    Boolean deleteAccountInfoById(BigInteger id);

}
