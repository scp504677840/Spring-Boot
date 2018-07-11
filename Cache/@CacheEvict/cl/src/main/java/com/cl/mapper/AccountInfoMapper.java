package com.cl.mapper;

import com.cl.entities.AccountInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigInteger;

public interface AccountInfoMapper {

    @Select("select * from account_info where id = #{id}")
    AccountInfo getAccountInfo(BigInteger id);

    @Update("update account_info set gmt_modified = #{gmtModified},name = #{name},balance = #{balance} where id = #{id}")
    Boolean updateAccountInfo(AccountInfo accountInfo);

    @Delete("delete from account_info where id = #{id}")
    Boolean deleteAccountInfoById(BigInteger id);

}
