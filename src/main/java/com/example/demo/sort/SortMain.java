package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Description： 排序相关
 * @Author：GuoFeng
 * @CreateTime：2020:04:30
 */
@Slf4j
public class SortMain {

    public static void main(String[] args) {
        //冒泡排序算法
        int[] numbers = new int[]{1, 5, 8, 2, 3, 9, 4};
        int i, j;
        for (i = 0; i < numbers.length - 1; i++) {
            for (j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        log.info(" \n ========== 冒泡排序：从小到大排序后的结果是:");
        for (i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        log.info(" \n ========== 快速排序的结果是：");
        Arrays.sort(numbers);
        for (int k = 0; k < numbers.length; k++) {
            System.out.print(numbers[k] + " ");

        }
    }
}
