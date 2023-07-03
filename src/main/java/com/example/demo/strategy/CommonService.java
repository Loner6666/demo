package com.example.demo.strategy;

/**
 * @Description：策略模式公共接口层
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
public interface CommonService {

    /**
     * 获取类型
     *
     * @return 类型
     */
    Integer type();

    /**
     * 各自方法
     *
     * @return 返回体
     */
    String say();

}
