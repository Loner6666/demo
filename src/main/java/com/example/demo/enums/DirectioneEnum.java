package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Description：方向枚举类
 * Author：GuoFeng
 * CreateTime：2021-12-30
 */
@Getter
@AllArgsConstructor
public enum DirectioneEnum {
    /**
     * 东-E
     */
    EAST("E", "东"),
    /**
     * 南-S
     */
    SOUTH("S", "南"),
    /**
     * 西-W
     */
    WEST("W", "西"),
    /**
     * 北-N
     */
    NORTH("N", "北"),
    ;

    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    /**
     * 根据code翻译desc
     *
     * @param code 代码
     * @return 描述
     */
    public static String getDescByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (DirectioneEnum item : DirectioneEnum.values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item.getDesc();
                }
            }
        }
        return null;
    }

}
