package com.example.demo.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description：策略模式工厂类
 * @Author：GuoFeng
 * @CreateTime：2023-07-03
 */
@Component
public class CommonServiceFactory implements ApplicationContextAware, InitializingBean {

    @Resource
    private ApplicationContext applicationContext;

    public static final Map<Integer, CommonService> COMMON_SERVICE_MAP = new ConcurrentHashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CommonService> commonServiceMap = applicationContext.getBeansOfType(CommonService.class);
        if (!commonServiceMap.isEmpty()) {
            for (CommonService commonService : commonServiceMap.values()) {
                Integer type = commonService.type();
                if (type != null) {
                    COMMON_SERVICE_MAP.put(type, commonService);
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据类型获取对于接口模型
     *
     * @param type 类型
     * @return 接口模型
     */
    public CommonService get(Integer type) {
        return COMMON_SERVICE_MAP.get(type);
    }

}
