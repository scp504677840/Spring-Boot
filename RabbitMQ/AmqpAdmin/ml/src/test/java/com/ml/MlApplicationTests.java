package com.ml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
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

    /**
     * 发送自定义对象消息
     * 1.书写自定义对象。
     * 2.发送消息。
     * 注意：我们将消息转换器换成了Jackson2JsonMessageConverter。
     */
    @Test
    public void sendObjectMessage() {
        String exchange = "exchange.direct";
        String routingKey = "lab.news";
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(1L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Tom");
        accountInfo.setBalance(BigDecimal.valueOf(999L));
        rabbitTemplate.convertAndSend(exchange, routingKey, accountInfo);

        //RabbitMQ后台显示的消息如下：
        //{"id":1,"gmtCreate":1531377603832,"gmtModified":1531377603832,"name":"Tom","balance":999}
    }

    /**
     * 接收自定义对象消息
     */
    @Test
    public void receiveObjectMessage() {
        Object message = rabbitTemplate.receiveAndConvert("lab.news");
        System.out.println("message.getClass: " + message.getClass());
        System.out.println(message);
        //message.getClass: class com.ml.AccountInfo
        //AccountInfo{id=1, gmtCreate=2018-07-12 14:40:03.832, gmtModified=2018-07-12 14:40:03.832, name='Tom', balance=999}
    }

    /**
     * 发送Direct消息
     * 点对点消息
     */
    @Test
    public void sendDirectMessage() {
        String exchange = "exchange.direct";
        String routingKey = "lab.news";
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(11L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Jack");
        accountInfo.setBalance(BigDecimal.valueOf(111L));
        rabbitTemplate.convertAndSend(exchange, routingKey, accountInfo);
    }

    /**
     * 接收Direct消息
     */
    @Test
    public void receiveDirectMessage() {
        Object message = rabbitTemplate.receiveAndConvert("lab.news");
        System.out.println("message.getClass: " + message.getClass());
        System.out.println(message);
    }

    /**
     * 发送Fanout消息
     * 广播消息
     * Fanout绑定的消息队列都能接收到。
     */
    @Test
    public void sendFanoutMessage() {
        String exchange = "exchange.fanout";
        String routingKey = "lab.news";
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(22L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Fanout");
        accountInfo.setBalance(BigDecimal.valueOf(222L));
        rabbitTemplate.convertAndSend(exchange, routingKey, accountInfo);
    }

    /**
     * 接收Fanout消息
     */
    @Test
    public void receiveFanoutMessage() {
        Object message = rabbitTemplate.receiveAndConvert("lab.news");
        System.out.println("message.getClass: " + message.getClass());
        System.out.println(message);
    }

    /**
     * 发送Topic消息
     * 模糊匹配消息
     * #：匹配0个或多个单词；如：#.news
     * *：匹配一个单词；如：*.news
     * Topic绑定的消息队列都能接收到。
     */
    @Test
    public void sendTopicMessage() {
        String exchange = "exchange.topic";
        String routingKey = "lab.news";
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(BigInteger.valueOf(33L));
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("Topic");
        accountInfo.setBalance(BigDecimal.valueOf(333L));
        rabbitTemplate.convertAndSend(exchange, routingKey, accountInfo);
    }

    /**
     * 接收Topic消息
     */
    @Test
    public void receiveTopicMessage() {
        Object message = rabbitTemplate.receiveAndConvert("lab.news");
        System.out.println("message.getClass: " + message.getClass());
        System.out.println(message);
    }

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * AmqpAdmin：可管理Exchange、Queue、Binding
     * 1.创建和删除Exchange
     * 2.创建和删除Queue
     * 3.创建和移除Binding
     */
    @Test
    public void testAmqpAdmin() {
        // 创建Exchange
        Exchange exchange = new DirectExchange("amqpadmin.exchange");
        amqpAdmin.declareExchange(exchange);

        // 创建Queue
        Queue queue = new Queue("amqpadmin.queue", true);
        amqpAdmin.declareQueue(queue);

        // 创建Binding
        Binding binding = new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqpadmin.news", null);
        amqpAdmin.declareBinding(binding);

        // 移除绑定
        amqpAdmin.removeBinding(binding);
        // 删除Queue
        amqpAdmin.deleteQueue("amqpadmin.queue");
        // 删除Exchange
        amqpAdmin.deleteExchange("amqpadmin.exchange");
    }

}
