package com.es;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Test
    public void createIndex() {
        // 创建文档
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(1L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom");
        accountInfo.setBalance(BigDecimal.valueOf(100L));
        // 构建索引
        Index index = new Index.Builder(accountInfo)
                .index("lab")
                .type("accountInfo")
                .build();
        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
