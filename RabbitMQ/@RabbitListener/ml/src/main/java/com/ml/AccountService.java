package com.ml;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 监听消息
 * 1.给配置类加上@EnableRabbit，启用基于注解的RabbitMQ
 * 2.书写AccountService监听类及带有@RabbitListener注解的监听方法。
 */
@Service
public class AccountService {

    /**
     * 监听具体对象
     *
     * @param accountInfo
     */
    @RabbitListener(queues = "lab.news")
    public void receiveAccountInfo(AccountInfo accountInfo){
        System.out.println(accountInfo);
    }

    /**
     * 监听Message消息，可以获取到MessageProperties
     *
     * @param message
     */
    public void receiveMessage(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }

}
