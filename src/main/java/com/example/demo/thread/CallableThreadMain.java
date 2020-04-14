package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author：GuoFeng
 * @Description： 多线程创建方式三，实现 Callable 接口
 * @data：2020:04:14
 */
@Slf4j
public class CallableThreadMain {

    public static void main(String[] args) {
        try {
            log.info("多线程创建方式三，实现 Callable 接口————>start");

            MyCallableThread mt1 = new MyCallableThread("一号窗口");
            MyCallableThread mt2 = new MyCallableThread("二号窗口");
            MyCallableThread mt3 = new MyCallableThread("三号窗口");
            Object call1 = mt1.call();
            Object call2 = mt2.call();
            Object call3 = mt3.call();

            System.out.println("mt1执行结果：" + call1);
            System.out.println("mt2执行结果：" + call2);
            System.out.println("mt3执行结果：" + call3);

            log.info("多线程创建方式三，实现 Callable 接口————>end");
        } catch (Exception e) {
            log.error("多线程创建方式三，实现 Callable 接口————>error【{},{}】", e.getMessage(), e);
        }
    }

}

class MyCallableThread implements Callable {

    private int ticket = 10;
    private String name;

    public MyCallableThread(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {

        for (int i = 0; i < 500; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "卖票---->" + (this.ticket--));
            }
        }

        return "SUCCESS";
    }
}