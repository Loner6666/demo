package com.example.demo.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description：两个数组求差集
 * @Author：GuoFeng
 * @CreateTime：2023-08-08
 */
public class Test3 {
    public static List<Integer> arrayDiff(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2) {
            set2.add(num);
        }

        // 计算差集
        set1.removeAll(set2);

        List<Integer> diffList = new ArrayList<>(set1);
        return diffList;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 5, 9};
        int[] array2 = {1, 2, 9};

        List<Integer> diff = arrayDiff(array1, array2);
        System.out.println(diff);  // 输出：[3, 5]
    }

}
