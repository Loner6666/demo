package com.example.demo;

import com.example.demo.enums.DirectioneEnum;
import org.junit.Test;

/**
 * Description：枚举类单元测试类
 * Author：GuoFeng
 * CreateTime：2021-12-30
 */
public class EnumTest {

    /**
     * 根据code获取desc单元测试
     */
    @Test
    public void testDirectioneEnum() {
        String descByCode = DirectioneEnum.getDescByCode("S");
        System.out.println(descByCode);
    }

}
