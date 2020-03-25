package com.example.demo.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author：Administrator
 * @Description： jedis cluster spring boot starter自动配置类
 * @data：2020:03:25
 */
@Configuration
@EnableConfigurationProperties(JedisClusterProperties.class)
@ConditionalOnProperty(prefix = "jedis.cluster", name = "server-list")
public class JedisClusterConfiguration {

    private final JedisClusterProperties jedisClusterProperties;

    @Autowired
    public JedisClusterConfiguration(JedisClusterProperties jedisClusterProperties) {
        this.jedisClusterProperties = jedisClusterProperties;
    }

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        List<String> serverList = jedisClusterProperties.getServerList();
        for (String redisAddr : serverList) {
            String[] hostAndPort = redisAddr.split(":");
            jedisClusterNodes.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
        }

        // 配置连接池的参数
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(jedisClusterProperties.getMaxTotal());
        poolConfig.setMaxWaitMillis(jedisClusterProperties.getMaxWaitMillis());
        poolConfig.setMinIdle(jedisClusterProperties.getMinIdle());
        poolConfig.setMaxIdle(jedisClusterProperties.getMaxIdle());
        poolConfig.setTestWhileIdle(jedisClusterProperties.isTestWhileIdle());
        poolConfig.setMinEvictableIdleTimeMillis(jedisClusterProperties.getMinEvictableIdleTimeMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(jedisClusterProperties.getTimeBetweenEvictionRunsMillis());
        poolConfig.setNumTestsPerEvictionRun(jedisClusterProperties.getNumTestsPerEvictionRun());
        return new JedisCluster(jedisClusterNodes, jedisClusterProperties.getTimeout(), jedisClusterProperties.getTimeout(), 5, jedisClusterProperties.getPassword(), poolConfig);
    }

}
