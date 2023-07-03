package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @Description：接口B
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
@Component
public class CommonServiceB extends AbstractCommonService {

    @Override
    public Integer type() {
        return 2;
    }

    @Override
    public String say() {
        return "CommonServiceB";
    }

}
