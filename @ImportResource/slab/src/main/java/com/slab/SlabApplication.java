package com.slab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 注解@ImportResource：导入Spring配置
 */
@ImportResource("classpath:app.xml")
@SpringBootApplication
public class SlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlabApplication.class, args);
    }
}
