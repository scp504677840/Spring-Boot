package com.ll.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 监听SpringIOC容器初始化
 *
 * spring-boot-autoconfigure-2.0.3.RELEASE.jar!/META-INF/spring.factories/META-INF/spring.factories
 *
 * 注意：
 * 一定要在META-INF/spring.factories文件里配置该类。
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer#initialize: " + applicationContext);
    }
}
