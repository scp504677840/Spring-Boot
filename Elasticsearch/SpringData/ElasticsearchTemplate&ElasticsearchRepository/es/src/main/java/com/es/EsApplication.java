package com.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * EsApplicationTests
 * 参考示例：
 * https://github.com/ameizi/elasticsearch-jest-example/blob/master/src/main/java/net/aimeizi/client/elasticsearch/TransportClient.java
 */
@SpringBootApplication
@EnableElasticsearchRepositories(value = "com.es")
public class EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class, args);
    }
}
