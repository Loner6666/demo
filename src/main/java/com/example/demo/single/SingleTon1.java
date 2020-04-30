package com.example.demo.single;

/**
 * @Description： 懒汉式(线程安全 ， 调用效率不高 ， 但是能延时加载)：
 * @Author：GuoFeng
 * @CreateTime：2020:04:30
 */
public class SingleTon1 {

    //类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)
    private static SingleTon1 instance;

    //构造器私有化
    private SingleTon1() {
    }

    //方法同步，调用效率低
    public static synchronized SingleTon1 getInstance() {
        if (instance == null) {
            instance = new SingleTon1();
        }
        return instance;
    }

}
