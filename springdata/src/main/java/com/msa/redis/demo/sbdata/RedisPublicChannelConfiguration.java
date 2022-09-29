package com.msa.redis.demo.sbdata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Map;

@Configuration
public class RedisPublicChannelConfiguration {
    @Bean
    public RedisMessageListenerContainer container(
            RedisConnectionFactory connectionFactory,
            Map<String, MessageListenerAdapter> adapterMap) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        adapterMap.keySet().forEach(topic->{
            container.addMessageListener(adapterMap.get(topic),new PatternTopic(topic));
        });
        return container;
    }

    @SuppressWarnings("all")
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置key的序列化规则和value的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}