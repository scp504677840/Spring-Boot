package com.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 注入StatViewServlet
     *
     * @return StatViewServlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> statViewServlet = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> params = new HashMap<>();
        // 如何进入后台? http://localhost:8080/druid
        //params.put("druid-user", "");
        // 后台账户
        params.put("loginUsername", "admin");
        // 密码
        params.put("loginPassword", "123456");
        // 允许谁访问，若不写则允许所有人访问
        params.put("allow", "192.168.0.102");
        // 拒绝谁访问
        params.put("deny", "192.168.0.111");
        statViewServlet.setInitParameters(params);
        return statViewServlet;
    }

    /**
     * 注入WebStatFilter
     *
     * @return WebStatFilter
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> webStatFilter = new FilterRegistrationBean<>();
        webStatFilter.setFilter(new WebStatFilter());
        Map<String, String> params = new HashMap<>();
        //params.put("profileEnable", "");
        //params.put("sessionStatEnable", "");
        //params.put("sessionStatMaxCount", "");
        // 排除哪些请求，也就是哪些请求是不拦截的。
        params.put("exclusions", "*.js,*.css,/druid/*");
        //params.put("principalSessionName", "");
        //params.put("principalCookieName", "");
        //params.put("realIpHeader", "");
        webStatFilter.setInitParameters(params);
        webStatFilter.setUrlPatterns(Collections.singletonList("/*"));
        return webStatFilter;
    }

}
