package com.example.demo.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description：集合排序
 * @Author：GuoFeng
 * @CreateTime：2023-07-21
 */
public class SortTest {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> allList = new ArrayList<>();
        allList.addAll(list1);
        allList.addAll(list2);
        // 冒泡排序
        for (int i = 0; i < allList.size() - 1; i++) {
            for (int j = i + 1; j < allList.size() - 1; j++) {
                if (allList.get(i) > allList.get(j)) {
                    Integer temp = allList.get(i);
                    allList.set(i, allList.get(j));
                    allList.set(j, temp);
                }
            }
        }
        System.out.println(allList);
        // 集合类
        TreeSet<Integer> set = new TreeSet<>(allList);
        System.out.println(set);
        // stream流
        List<Integer> collect = allList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
