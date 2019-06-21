package com.novel.cn.config.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Map;

/**
 * 【作者】: Miaohw
 * 【日期】：2018-09-13 16:43
 * 【描述】：
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {


    @Bean(name = "redisClient")
    public RedisTemplate<String, List<Map<String, Object>>> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, List<Map<String, Object>>> template = new RedisTemplate<String, List<Map<String, Object>>>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
