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

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Autowired
    private RedisTemplate<Object,AccountInfo> accountInfoRedisTemplate;

    @Test
    public void testObject() {
        ValueOperations vo = redisTemplate.opsForValue();
        //默认保存对象使用的是jdk序列化方式。
        AccountInfo accountInfo = accountInfoMapper.getAccountInfo(BigInteger.valueOf(1L));
        //vo.set("accountInfo",accountInfo);

        //如何使用json方式保存对象数据？
        //1.自行将数据先json化，然后再进行存储。
        //2.改变默认的序列化器：
        //步骤1.书写RedisConfig类并加上@Configuration注解
        //步骤2.书写RedisTemplate<Object, AccountInfo> accountInfoRedisTemplate(RedisConnectionFactory redisConnectionFactory)方法并加上@Bean注解
        //步骤3.书写方法体
        //RedisTemplate<Object,AccountInfo> template = new RedisTemplate<>();
        //        template.setConnectionFactory(redisConnectionFactory);
        //        Jackson2JsonRedisSerializer<AccountInfo> rs = new Jackson2JsonRedisSerializer<>(AccountInfo.class);
        //        template.setDefaultSerializer(rs);
        //        return template;
        //步骤4.使用新定义的accountInfoRedisTemplate序列化器。

        ValueOperations<Object, AccountInfo> avo = accountInfoRedisTemplate.opsForValue();
        avo.set("accountInfo",accountInfo);

        Object info = vo.get("accountInfo");
        System.out.println(info);
        if (accountInfo != null) {
            System.out.println(info.getClass().getName());
            System.out.println(info instanceof AccountInfo);
        }
        //AccountInfo{id=1, gmtCreate=2018-06-27 09:48:28.0, gmtModified=2018-06-27 10:48:32.0, name='Tom', balance=5555.00}
        //com.cl.entities.AccountInfo
        //true
    }

}
