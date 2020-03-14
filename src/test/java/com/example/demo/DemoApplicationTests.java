package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void demoTest() {
        System.out.println("demo 单元测试！");
        log.info("demo 单元测试！");
    }

}
