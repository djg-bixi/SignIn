package com.djg.signin.common.timedTasks;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.djg.signin.domain.User;
import com.djg.signin.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * @NAME: ScheduledTask
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@Configuration
@EnableScheduling
public class ScheduledTask {
    public Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    @Autowired
    UserMapper userMapper;


    /**
     * 每月清除用户的 月累计天数
     */
    @Scheduled(cron = "0 59 23 28-31 * ?")
    public void monthClear(){
        int i = userMapper.updateMonthDay();
        if (i>0) logger.info("==>每月清除用户累计天数成功。");
    }


}
