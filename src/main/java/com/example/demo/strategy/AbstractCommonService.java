package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @Description：策略模式抽象接口层
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
@Component
public abstract class AbstractCommonService implements CommonService {

    public abstract Integer type();

    public abstract String say();

}
