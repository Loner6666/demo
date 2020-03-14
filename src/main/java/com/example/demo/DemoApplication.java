package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j//打印日志
@SpringBootApplication//标识为主启动类
@MapperScan("com.example.demo.mapper")//扫描MyBatis的mapper.java接口包
@EnableScheduling//启用定时任务
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("服务启动成功！");
    }

}
