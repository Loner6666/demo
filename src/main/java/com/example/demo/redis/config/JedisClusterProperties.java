package com.example.demo.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author：Administrator
 * @Description： REDIS 集群参数 配置
 * @data：2020:03:25
 */
@ConfigurationProperties(prefix = "jedis.cluster")
@Validated
@Data
public class JedisClusterProperties {

    @NotEmpty
    private List<String> serverList;

    private int timeout = 1000;

    private int maxTotal = 8;

    private int minIdle = 0;

    private int maxIdle = 8;

    private long maxWaitMillis = -1L;

    private boolean testWhileIdle = true;

    private long minEvictableIdleTimeMillis = 60000;

    private long timeBetweenEvictionRunsMillis = 30000;

    private int numTestsPerEvictionRun = -1;

    private String password;

}
