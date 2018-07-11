package com.cl;

import com.cl.entities.AccountInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, AccountInfo> accountInfoRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,AccountInfo> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<AccountInfo> rs = new Jackson2JsonRedisSerializer<>(AccountInfo.class);
        template.setDefaultSerializer(rs);
        return template;
    }

}
