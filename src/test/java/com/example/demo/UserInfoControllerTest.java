package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserInfo;
import com.example.demo.common.ResultObject;
import com.example.demo.services.UserInfoServices;
import com.example.demo.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info，控制器的单元测试
 * @data：2020：03:13
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserInfoControllerTest {

    @Autowired
    private UserInfoServices userInfoServices;

    /**
     * 查询user_info所有数据单元测试
     * * URL： /gmall/getUserInfo
     */
    @Test
    public void getUserInfoTest() {
        try {
            log.info("查询user_info所有数据单元测试，start————>");
            List<UserInfo> userInfoList = this.userInfoServices.getUserInfo();
            log.info("查询user_info所有数据单元测试，end————>{}", JSON.toJSONString(userInfoList));
        } catch (Exception e) {
            log.info("查询user_info所有数据单元测试，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * * 分页查询user_info单元测试
     * * URL： /gmall/getUserInfoPage
     */
    @Test
    public void getUserInfoPage() {
        try {
            UserInfoVo request = new UserInfoVo();
            request.setPageNum(1);
            request.setPageSize(2);
            log.info("分页查询user_info单元测试，start————>{}", JSON.toJSONString(request));
            ResultObject responseData = this.userInfoServices.getUserInfoPage(request);
            log.info("分页查询user_info单元测试，end————>{}", JSON.toJSONString(responseData));
        } catch (Exception e) {
            log.info("分页查询user_info单元测试，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
        }
    }

}
