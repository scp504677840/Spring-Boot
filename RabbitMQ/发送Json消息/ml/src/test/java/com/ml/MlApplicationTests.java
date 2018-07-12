package com.ml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MlApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() {
        String exchange = "exchange.direct";
        String routingKey = "lab.news";

        //发送消息方式一：
        //构建消息方式一：创建Message
        //Message message = new Message("hi".getBytes(), new MessageProperties());
        //构建消息方式二：消息转换器
        //SimpleMessageConverter smc = new SimpleMessageConverter();
        //Message message = smc.toMessage("hi", new MessageProperties());
        //rabbitTemplate.send(exchange, routingKey, message);

        //发送消息方式二：
        rabbitTemplate.convertAndSend(exchange, routingKey, "springboot");
    }

    /**
     * 接收消息
     */
    @Test
    public void receiveMessage() {
        Object message = rabbitTemplate.receiveAndConvert("lab.news");
        System.out.println("message.getClass: " + message.getClass());
        System.out.println(message);
        //message.getClass: class java.lang.String
        //springboot
    }

    /**
     * 发送Json消息
     * 1.书写MyRabbitMQConfig并加上@Configuration
     * 2.书写public MessageConverter messageConverter() 方法并加上@Bean
     * 3.messageConverter()方法返回new Jackson2JsonMessageConverter()
     * 4.再发送消息即可。
     */
    @Test
    public void sendJsonMessage() {
        String exchange = "exchange.direct";
        String routingKey = "lab.news";
        Map<String, Object> message = new HashMap<>();
        message.put("name", "tom");
        message.put("age", "18");
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
