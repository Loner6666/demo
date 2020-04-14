package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：GuoFeng
 * @Description： Conlltion集合相关单元测试
 * @data：2020:04:12
 */
@Slf4j
@RunWith(SpringRunner.class)
public class ConlltionTest {

    /**
     * 数组转list使用Arrays.asList(T... a)方法
     */
    @Test
    public void ArrayToListTest() {
        log.info("========== 数组转List ==========");
        String[] stringArray = {"hello", "world", "A"};
        System.out.println("当前数组：" + Arrays.toString(stringArray));

        List<String> stringList = Arrays.asList(stringArray);
        System.out.println("数组转list使用Arrays.asList(T... a)方法======" + stringList);
    }

    /**
     * list转数组用list.toArray()方法
     */
    @Test
    public void ListToArrayTest() {
        log.info("========== List转数组 ==========");
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("A !");
        System.out.println("当前List：" + list);

        Object[] array = list.toArray();
        System.out.println("list转数组用list.toArray()方法" + Arrays.toString(array));
    }

}
