package com.example.demo.interview;

/**
 * @Description：生产随机数
 * @Author：GuoFeng
 * @CreateTime：2023-08-15
 */
public class BService {

    public static Integer get() {
        Integer result = (int) (Math.random() * 100);
        return result;
    }

}
