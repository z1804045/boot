package com.itheima.config;

import com.itheima.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import sun.security.krb5.internal.Ticket;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, User> ticketRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
        RedisTemplate<Object,User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<User>(User.class);
        redisTemplate.setDefaultSerializer(serializer);
        return redisTemplate;
    }
}
