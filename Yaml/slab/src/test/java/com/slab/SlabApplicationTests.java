package com.slab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlabApplicationTests {

    @Autowired
    private Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
        //Person{name='tom', age=12, boss=false, birth=Tue Dec 12 00:00:00 CST 2017, maps={k1=v1, k2=v2}, lists=[cher, jack], address=Address{city='shanghai', street='lu'}}
    }

}
