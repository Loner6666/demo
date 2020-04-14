package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：GuoFeng
 * @Description： 多线程创建方式二，实现 Runnable 接口
 * @data：2020:04:14
 */
@Slf4j
public class RunnableThreadMain {

    public static void main(String[] args) {
        log.info("多线程创建方式二，实现 Runnable 接口————>start");

        MyRunThread mt1 = new MyRunThread("一号窗口");
        MyRunThread mt2 = new MyRunThread("二号窗口");
        MyRunThread mt3 = new MyRunThread("三号窗口");
        mt1.run();
        mt2.run();
        mt3.run();

        log.info("多线程创建方式二，实现 Runnable 接口————>end");
    }

}

class MyRunThread implements Runnable {

    private int ticket = 10;
    private String name;

    public MyRunThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "卖票---->" + (this.ticket--));
            }
        }
    }
}