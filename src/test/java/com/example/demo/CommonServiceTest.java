package com.example.demo;

import com.example.demo.strategy.CommonService;
import com.example.demo.strategy.CommonServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description：策略模式单元测试类
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CommonServiceTest {

    @Resource
    private CommonServiceFactory commonServiceFactory;

    @Test
    public void test() {
        CommonService commonService1 = commonServiceFactory.get(1);
        System.out.println(commonService1.type());
        System.out.println(commonService1.say());

        CommonService commonService2 = commonServiceFactory.get(2);
        System.out.println(commonService2.type());
        System.out.println(commonService2.say());
    }

}
