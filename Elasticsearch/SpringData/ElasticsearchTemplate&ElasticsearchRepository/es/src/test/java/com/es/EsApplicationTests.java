package com.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Autowired
    private AccountInfoESRepository accountInfoESRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 测试elasticsearch的SpringData客户端
     * 1.添加配置application.yml
     * spring:
     *   data:
     *     elasticsearch:
     *       cluster-name: elasticsearch
     *       cluster-nodes: 192.168.0.101:9300
     * 2.书写AccountInfo POJO类，并在类上注解@Document(indexName = "lab",type = "accountInfo")
     * 3.书写AccountInfoESRepository继承自extends ElasticsearchRepository<AccountInfo, BigInteger>
     * 4.书写测试方法。
     */
    @Test
    public void testSpringData(){
        /*// 创建文档
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(3L);
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tk");
        accountInfo.setBalance(BigDecimal.valueOf(333L));
        AccountInfo index = accountInfoESRepository.index(accountInfo);
        System.out.println(index);*/
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", "Tom");
        SearchQuery query = new NativeSearchQuery(queryBuilder);
        //查询数据 主要依赖 QueryBuilder 对象 ，可以通过 QueryBuilders 获取
        //boolQuery() 布尔查询，可以用来组合多个查询条件
        //fuzzyQuery() 相似度查询
        //matchAllQuery() 查询所有数据
        //regexpQuery() 正则表达式查询
        //termQuery() 词条查询
        //wildcardQuery() 模糊查询
        AggregatedPage<AccountInfo> accountInfos = elasticsearchTemplate.queryForPage(query, AccountInfo.class);
        accountInfos.forEach(System.out::println);
    }

}
