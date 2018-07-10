package com.slab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlabApplicationTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

        //运行结果：
        //2018-07-10 13:27:45.755  INFO 5029 --- [           main] com.slab.SlabApplicationTests            : 这是info日志
        //2018-07-10 13:27:45.756  WARN 5029 --- [           main] com.slab.SlabApplicationTests            : 这是warn日志
        //2018-07-10 13:27:45.756 ERROR 5029 --- [           main] com.slab.SlabApplicationTests            : 这是error日志
        //从运行结果来看，我们知道SpringBoot默认的日志级别是info。
    }

}
