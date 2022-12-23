package com.jeff.config;

import com.jeff.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quartzconfig {
    @Bean
    //工作明细, 绑定具体的工作
    public JobDetail printJobDetail(){
        //工作明细, 绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }
    @Bean
    //触发器, 绑定工作明细
    public Trigger printJobTrigger(){
        ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?"); //秒 分 时 日 月 星期
        //绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();
    }
}
