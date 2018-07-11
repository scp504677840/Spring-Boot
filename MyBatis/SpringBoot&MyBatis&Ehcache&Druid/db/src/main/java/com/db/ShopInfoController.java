package com.db;

import com.db.entities.ShopInfo;
import com.db.mapper.ShopInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class ShopInfoController {

    @Autowired
    private ShopInfoMapper shopInfoMapper;

    /**
     * http://localhost:8080/getShopInfo/1
     *
     * @param id 店铺Id
     * @return 店铺信息
     */
    @GetMapping("/getShopInfo/{id}")
    public ShopInfo getShopInfo(@PathVariable("id") BigInteger id) {
        return shopInfoMapper.getShopInfoById(id);
    }

}
