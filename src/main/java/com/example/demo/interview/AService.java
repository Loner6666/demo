package com.example.demo.interview;

/**
 * @Description：生产随机数
 * @Author：GuoFeng
 * @CreateTime：2023-08-15
 */
public class AService {

    public static Integer get() {
        Integer result = (int) (Math.random() * 100);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(get());
    }

}
