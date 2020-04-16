package com.example.demo.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author：GuoFeng
 * @Description： Java通过Executors提供四种线程池，分别为：
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * <p>
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * <p>
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * <p>
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @data：2020:04:16
 */
@Slf4j
public class NewFixedThreadPoolMain {
    public static void main(String[] args) {
        log.info("newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(1000);
                        log.info("Executors.newFixedThreadPool(3);Thread.sleep(1000);====【{}】", fixedThreadPool.toString());
                    } catch (InterruptedException | RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
