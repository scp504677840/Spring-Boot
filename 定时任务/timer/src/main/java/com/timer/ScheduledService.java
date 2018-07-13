package com.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * 注解@Scheduled：定时任务
     * cron：时间表达式
     * second（秒） minute（分） hour（时） day of month（月中哪一天） month（月） day of week（星期几）
     * 示例：0 * * * * MON-FRI 周一到周五，每分钟整执行一次。
     * 0,1,2,3 * * * * MON-FRI 周一到周五，每分钟整及1、2、3秒都执行一次。
     * 0 0 2 LW * ? 每个月的最后一个工作日凌晨2点执行一次。
     *
     * 特殊字符：
     * ,：枚举
     * -：区间
     * *：任意
     * /：步长；0/3 * * * * MON-FRI（每隔3秒执行一次）
     * ?：日／星期冲突匹配；0 * * * * MON（不是每一天都是星期一，所以应该表示为0 * * ? * MON）；0 * * 1 * MON（不是每个月的1号都是星期一，所以应该表示为0 * * 1 * ?）
     * L：最后
     * W：工作日
     * C：和calendar联系后计算过的值
     * #：星期；4#2，第2个星期四
     * 注意：
     * 在星期里面，可以写数字0-7
     * 其中，1-6代表星期一到星期六
     * 0和7代表星期日
     */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3 * * * * MON-FRI")
    //@Scheduled(cron = "0-3 * * * * MON-FRI")
    @Scheduled(cron = "0/3 * * * * MON-FRI")
    public void say(){
        System.out.println("hi...");
    }

}
