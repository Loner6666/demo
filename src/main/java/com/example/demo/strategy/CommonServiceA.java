package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @Description：接口A
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
@Component
public class CommonServiceA extends AbstractCommonService {

    @Override
    public Integer type() {
        return 1;
    }

    @Override
    public String say() {
        return "CommonServiceA";
    }

}
