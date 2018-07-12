package com.es;

import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.MetricAggregation;
import io.searchbox.params.SearchType;
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
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Test
    public void createIndex() {
        // 创建文档
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(2L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Ti");
        accountInfo.setBalance(BigDecimal.valueOf(222L));
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

    @Test
    public void search() {
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"Tom\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //DFS_QUERY_THEN_FETCH：精确查询
        //QUERY_THEN_FETCH：查询
        //COUNT：只计算结果的数量，也会执行facet。
        //SCAN：在执行了没有进行任何排序的检索时执行浏览。此时将会自动的开始滚动结果集。
        Search search = new Search.Builder(query).setSearchType(SearchType.DFS_QUERY_THEN_FETCH).build();
        try {
            SearchResult searchResult = jestClient.execute(search);
            System.out.println("-----------------------------------");
            System.out.println(searchResult.getJsonString());
            System.out.println("-----------------------------------");
            System.out.println("Total: " + searchResult.getTotal());
            if (searchResult.getTotal() != null) {
                System.out.println("MaxScore: " + searchResult.getMaxScore());
                SearchResult.Hit<AccountInfo, Void> firstHit = searchResult.getFirstHit(AccountInfo.class);
                System.out.println(firstHit.source);
                System.out.println("-----------------------------------");
                List<SearchResult.Hit<AccountInfo, Void>> searchResultHits = searchResult.getHits(AccountInfo.class);
                searchResultHits.forEach(accountInfoVoidHit -> {
                    System.out.println(accountInfoVoidHit.source);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------------------------------
        //{"took":22,"timed_out":false,"_shards":{"total":10,"successful":10,"skipped":0,"failed":0},"hits":{"total":1,"max_score":0.6931472,"hits":[{"_index":"lab","_type":"accountInfo","_id":"1","_score":0.6931472,"_source":{"id":1,"gmtCreate":"Jul 12, 2018, 11:18:22 PM","gmtModified":"Jul 12, 2018, 11:18:22 PM","name":"Tom","balance":100}}]}}
        //-----------------------------------
        //Total: 1
        //MaxScore: 0.6931472
        //AccountInfo{id=1, gmtCreate=2018-07-12 23:18:22.0, gmtModified=2018-07-12 23:18:22.0, name='Tom', balance=100}
        //-----------------------------------
        //AccountInfo{id=1, gmtCreate=2018-07-12 23:18:22.0, gmtModified=2018-07-12 23:18:22.0, name='Tom', balance=100}
    }

}
