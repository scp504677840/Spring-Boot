package com.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务
 * 1.TaskExecutor
 * 2.TaskScheduler
 * 3.@EnableScheduling：开启基于注解的定时任务
 * 4.@Scheduled：标记要执行的定时任务
 */
@EnableScheduling
@SpringBootApplication
public class TimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimerApplication.class, args);
    }
}
