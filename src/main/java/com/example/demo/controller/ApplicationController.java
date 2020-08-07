package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description： 获取application.yml中数据的值
 * SpringBoot获得application.yml中数据值的两种方式：
 * 方法一：
 * 使用注解：@Value("${spring.datasource.url}")
 * import org.springframework.beans.factory.annotation.Value;
 * 方法二：
 * 使用Environment： private Environment environment;
 * import org.springframework.core.env.Environment;
 * @Author：GuoFeng
 * @CreateTime：2020-08-07
 */
@Slf4j
@RestController
@PropertySource("classpath:application-dev.yml")//读取application-dev.yml文件
public class ApplicationController {

    //获取数据库url
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Autowired
    private Environment environment;

    /**
     * URL： http://localhost:8081/gmall/getYml1
     * 方法一：
     * 使用注解：@Value("${spring.datasource.url}")
     * import org.springframework.beans.factory.annotation.Value;
     *
     * @return
     */
    @GetMapping("/getYml1")
    public String getYml1() {
        //获取数据库链接 spring.datasource.url=jdbc:mysql://localhost:3306/gmall
        log.info("ApplicationController.getYml1————》数据库链接为：{}", datasourceUrl);
        return "ApplicationController.getYml1————》数据库链接为：" + datasourceUrl;
    }

    /**
     * URL： http://localhost:8081/gmall/getYml2
     * 方法二：
     * 使用Environment： private Environment environment;
     * import org.springframework.core.env.Environment;
     *
     * @return
     */
    @GetMapping("/getYml2")
    public String getYml2() {
        //获取数据库链接 spring.datasource.url=jdbc:mysql://localhost:3306/gmall
        String DBUrl = environment.getProperty("spring.datasource.url");
        log.info("ApplicationController.getYml2————》数据库链接为：{}", DBUrl);
        return "ApplicationController.getYml2————》数据库链接为：" + DBUrl;
    }

}
