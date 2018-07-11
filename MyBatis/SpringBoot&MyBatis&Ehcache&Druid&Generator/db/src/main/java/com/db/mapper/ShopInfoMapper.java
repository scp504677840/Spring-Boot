package com.db.mapper;

import com.db.entities.ShopInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

public interface ShopInfoMapper {

    ShopInfo getShopInfoById(@Param("id") BigInteger id);

}
