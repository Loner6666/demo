package com.example.demo.interview;

import java.util.concurrent.*;

/**
 * @Description： 编写一个Java函数，通过调用AService.get()、BService.get()、CService.get()三个接口，获取三个整数，然后将这三个整数累加，最终返回累加的值。要求：
 * 1.调用三个接口的操作需要并行执行，以提高效率；
 * 2.累加操作需要在获取三个整数的操作完成后进行，因此需要保证三个整数均已获取后才能进行累加操作；
 * 3.考虑多线程安全问题。
 * @Author：GuoFeng
 * @CreateTime：2023-08-15
 */
public class Test1 {
    public static int accumulateIntegers() throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 定义三个异步任务
        Callable<Integer> taskA = () -> AService.get();
        Callable<Integer> taskB = () -> BService.get();
        Callable<Integer> taskC = () -> CService.get();

        // 提交任务并获取Future对象
        Future<Integer> futureA = executor.submit(taskA);
        Future<Integer> futureB = executor.submit(taskB);
        Future<Integer> futureC = executor.submit(taskC);

        // 等待三个整数获取完毕
        int resultA = futureA.get();
        int resultB = futureB.get();
        int resultC = futureC.get();

        System.out.println("A:" + resultA + "\t B:" + resultB + "\t C:" + resultC);

        // 关闭线程池
        executor.shutdown();

        // 执行累加操作
        int sum = resultA + resultB + resultC;

        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int sum = accumulateIntegers();
        System.out.println("累加结果：" + sum);
    }
}
