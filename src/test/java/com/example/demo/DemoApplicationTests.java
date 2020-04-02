package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserInfo;
import com.example.demo.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void demoTest() {
        System.out.println("demo 单元测试！");
        log.info("demo 单元测试！");
    }

    /**
     * BeanUtils.copyProperties(source, target);
     * 实体类对象属性复制
     * public static void copyProperties(Object source, Object target)
     */
    @Test
    public void beanUtilsTest() {
        UserInfo userInfo = new UserInfo(1L, "用户名称", "用户昵称", "用户密码", "用户姓名", "手机号", "邮箱", "头像", "用户级别");
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo, userInfoVo);
        System.out.println(userInfoVo);
        log.info("userInfoVo【{}】", JSON.toJSONString(userInfoVo));
    }

    /**
     * 实体类对象 《====》JSON字符串
     * 互转
     */
    @Test
    public void jsonTest() {

        UserInfo userInfo = new UserInfo(1L, "用户名称", "用户昵称", "用户密码", "用户姓名", "手机号", "邮箱", "头像", "用户级别");

        //1、实体类对象转JSON字符串
        String jsonString = JSON.toJSONString(userInfo);
        System.out.println("实体类对象转JSON字符串：==" + jsonString);

        String userStr = "{\"email\":\"邮箱\",\"headImg\":\"头像\",\"id\":1,\"loginName\":\"用户名称\",\"name\":\"用户姓名\",\"nickName\":\"用户昵称\",\"passwd\":\"用户密码\",\"phoneNum\":\"手机号\",\"userLevel\":\"用户级别\"}";
        //2、JSON字符串转实体类对象
        UserInfo userInfo1 = JSON.parseObject(userStr, UserInfo.class);
        System.out.println("JSON字符串转实体类对象：==" + userInfo1);

    }

}
