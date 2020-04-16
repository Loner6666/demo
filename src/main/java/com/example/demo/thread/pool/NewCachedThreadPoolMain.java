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
public class NewCachedThreadPoolMain {
    public static void main(String[] args) {
        log.info("newCachedThreadPool 这里的线程池是无限大的，当一个线程完成任务之后，这个线程可以接下来完成将要分配的任务，而不是创建一个新的线程。");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
                log.info("Executors.newCachedThreadPool();Thread.sleep(1000);====【{}】", cachedThreadPool.toString());
            } catch (InterruptedException | RuntimeException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
