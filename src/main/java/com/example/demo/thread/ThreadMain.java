package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：GuoFeng
 * @Description： 多线程创建方式一，继承Thread类
 * @data：2020:04:14
 */
@Slf4j
public class ThreadMain {

    public static void main(String[] args) {
        log.info("多线程创建方式一，继承Thread类————>start");

        MyThread mt1 = new MyThread("一号窗口");
        MyThread mt2 = new MyThread("二号窗口");
        MyThread mt3 = new MyThread("三号窗口");
        mt1.start();
        mt2.start();
        mt3.start();

        log.info("多线程创建方式一，继承Thread类————>end");
    }

}

class MyThread extends Thread {

    private int ticket = 10;
    private String name;

    public MyThread(String name) {
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