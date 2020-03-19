package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Administrator
 * @Description： 示例
 * @data：2020：03:13
 */
@RestController
public class HelloController {

    /**
     * 示例
     * URL： localhost:8081/gmall/hello
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot！";
    }
}
