package com.cl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 注解@EnableCaching：开启缓存注解。
 */
@Configuration
@EnableCaching
@MapperScan("com.cl.mapper")
public class MyBatisConfig {
}
