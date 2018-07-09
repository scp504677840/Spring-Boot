package com.slab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlabApplicationTests {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void contextLoads() {
        boolean userService = ctx.containsBean("userService");
        System.out.println(userService);
    }

}
