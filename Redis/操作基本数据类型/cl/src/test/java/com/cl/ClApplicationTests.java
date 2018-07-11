package com.cl;

import com.cl.entities.AccountInfo;
import com.cl.mapper.AccountInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClApplicationTests {

    /**
     * StringRedisTemplate：主要操作String。
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * RedisTemplate：注意操作k-v键值对。
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis常见的五大数据类型
     * 1.String字符串
     * 2.List列表
     * 3.Set集合
     * 4.Hash散列
     * 5.ZSet有序集合
     * <p>
     * stringRedisTemplate.opsForValue()：操作String字符串
     * stringRedisTemplate.opsForList()：操作List列表
     * stringRedisTemplate.opsForSet()：操作Set集合
     * stringRedisTemplate.opsForHash()：操作Hash散列
     * stringRedisTemplate.opsForZSet()：操作ZSet有序集合
     */
    @Test
    public void testString() {
        ValueOperations<String, String> svo = stringRedisTemplate.opsForValue();
        Integer append = svo.append("msg", "hello");
        System.out.println("testString: " + append);
        String msg = svo.get("msg");
        System.out.println("testString: " + msg);
    }

    @Test
    public void testList() {
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        list.leftPush("mylist", "1");
        list.leftPush("mylist", "2");

        String value = list.leftPop("mylist");
        System.out.println(value);
        value = list.leftPop("mylist");
        System.out.println(value);
        value = list.leftPop("mylist");
        System.out.println(value);
        //2
        //1
        //null
    }

}
