package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：List分批处理
 * CreateTime：2021-12-29
 * Author：GuoFeng
 */
public class BatchListTest {

    @Test
    public void testBatList() {
        //获取数据
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //最终分批后的数据
        List<List<Integer>> alllist = new ArrayList<>();
        //每一批数据
        List<Integer> subList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                subList.add(list.get(i));
                if (subList.size() % 3 == 0) {
                    alllist.add(subList);
                    subList = new ArrayList<>();
                }
            }
        }
        if (subList.size() > 0) {
            alllist.add(subList);
        }
        System.out.println(alllist);
    }


}
