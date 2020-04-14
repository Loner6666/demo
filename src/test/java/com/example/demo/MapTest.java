package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author：GuoFeng
 * @Description： Map相关单元测试
 * @data：2020:04:12
 */
@Slf4j
@RunWith(SpringRunner.class)
public class MapTest {

    /**
     * 遍历Map的5种方法
     */
    @Test
    public void mapTest1() {
        //声明并赋值
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        log.info("1、 ========== Lambda表达式遍历map ==========");
        map.forEach((K, V) -> {
            System.out.println("【K : V】 = " + K + " : " + V);
        });

        log.info("2、 ========== map.keySet()遍历map ==========");
        for (String key : map.keySet()) {
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }

        log.info("3、 ========== map.entrySet()遍历map ==========");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }

        log.info("4、 ========== map.values()遍历map ==========");
        for (Object value : map.values()) {
            System.out.println("map.value = " + value);
        }

        log.info("5、 ========== iterator.hasNext()遍历map ==========");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }

    }

}
