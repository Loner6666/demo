package com.example.demo;

import com.example.demo.bean.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description： BeanUtils.copyProperties(source, target); 工具类相关
 * import org.springframework.beans.BeanUtils;
 * @Author：GuoFeng
 * @CreateTime：2020-08-11
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class BeanUtilsTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testBeanUtils() {
        UserInfo user = this.userInfoMapper.selectByPrimaryKey(1L);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        log.info("======= 单元测试： BeanUtils.copyProperties(user, userInfo);");
        System.out.println("user =====" + user);
        System.out.println("userInfo =====" + userInfo);
    }

    /**
     * 对象属性拷贝工具类的性能比较
     * 参考链接： https://www.cnblogs.com/exceptioneye/p/4852962.html
     *
     * 目前对象间属性的拷贝常用的方法大致如下：
     *
     * 手动拷贝(set)
     * 动态代理
     *        cglib版本：net.sf.cglib.beans.BeanCopier.copy(Object from, Object to, Converter converter)
     *
     * 反射机制
     *        Spring版本：org.springframework.beans.BeanUtils.copyProperties(Object source, Object target)
     *
     *        Apache版本：org.apache.commons.beanutils.PropertyUtils.copyProperties(Object dest, Object orig)
     *
     *                           org.apache.commons.beanutils.BeanUtils.copyProperties(Object dest, Object orig)
     *
     *       DozerMapper
     *
     * 结论：
     *        输出结果： manualCopy > cglibCopy > springBeanUtils > apachePropertyUtils > apacheBeanUtils 可以理解为: 手工复制 > cglib > 反射。
     *
     *         对于最求速度的属性拷贝，建议使用手动设置拷贝，虽然代码会变得臃肿不堪。
     *
     */

}
