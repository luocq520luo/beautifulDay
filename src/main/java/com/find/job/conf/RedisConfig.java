package com.find.job.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.util.logging.Logger;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    private static Logger logger = Logger.getLogger(RedisConfig.class.getName());

    @Bean
    @ConfigurationProperties(prefix = "redis")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        logger.info("JedisConnectionFactory bean init success.");
        return factory;
    }


    @Bean
    public RedisTemplate<String, Serializable> getRedisTemplate() {
        RedisTemplate<String, Serializable> template = new RedisTemplate();
        template.setConnectionFactory(getConnectionFactory());
        return template;
    }
}  