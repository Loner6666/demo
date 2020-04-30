package com.example.demo.single;

/**
 * @Description： 饿汉式(线程安全 ， 调用效率高 ， 但是不能延时加载)：
 * @Author：GuoFeng
 * @CreateTime：2020:04:30
 */
public class SingleTon2 {

    private static SingleTon2 instance = new SingleTon2();

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        return instance;
    }

}
