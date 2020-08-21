package com.example.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @author：Administrator
 * @Description： 定时任务实例
 * @data：2020:03:13
 */
@Slf4j
@Service
public class ScheduleTask {

    //cron表达式，示例
    //每隔5秒执行一次："*/5 * * * * ?"
    //每隔1分钟执行一次："0 */1 * * * ?"
    //每天凌晨1点执行一次："0 0 1 * * ?"

    /**
     * 每隔10min输出一下当前时间
     */
    @Scheduled(cron = "0 */10 * * * ?")
    public void execute() {
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        System.out.println("定时任务,每隔10min输出一下当前时间：" + sdf.format(System.currentTimeMillis()));
    }

}
