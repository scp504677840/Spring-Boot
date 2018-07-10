package com.wlab;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * 注册Servlet
     *
     * @return 注册Servlet的Bean
     */
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new MyServlet(), "/hi");
    }

    /**
     * 注册Filter
     *
     * @return 注册Filter的Bean
     */
    @Bean
    public FilterRegistrationBean<MyFilter> filterFilterRegistrationBean() {
        return new FilterRegistrationBean<>(new MyFilter(), servletRegistrationBean());
    }

    /**
     * 注册Listener
     *
     * @return 注册Listener的Bean
     */
    @Bean
    public ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }

}
