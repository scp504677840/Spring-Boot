package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入Spring Security
 * 2.MySecurityConfig extends WebSecurityConfigurerAdapter
 */
@SpringBootApplication
public class SlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlApplication.class, args);
    }
}
