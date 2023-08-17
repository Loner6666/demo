package com.example.demo.interview;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照顺序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相减，并以相同形式返回一个表示相减结果的链表。
 * 你可以假设
 * 1）除了数字 0 之外，这两个数都不会以 0 开头。
 * 2）给定的第一数字一定比第二个数字大。
 * 举例：
 * 输入：l1 = [9,8,7], l2 = [5,1,2]
 * 输出：[4,7,5]
 * 解释：987-512 = 475.
 * @Author：GuoFeng
 * @CreateTime：2023-08-15
 */
public class Test2 {
    public static void main(String[] args) {
        // 两个list
        List<Integer> list1 = Arrays.asList(9, 8, 7);
        List<Integer> list2 = Arrays.asList(5, 1, 2);
        // 输出的结果集
        List<Integer> resultList = new ArrayList<>();

        // 两个list不为空，并且长度相同时，相同下标位置的元素相减
        if (!CollectionUtils.isEmpty(list1) && !CollectionUtils.isEmpty(list2)
                && list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                int index = i;
                int diff = list1.get(index) - list2.get(index);
                resultList.add(diff);
            }
        }

        System.out.println(resultList);
    }
}
