package com.jeff;

import com.jeff.quartz.MyQuartz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务功能
@EnableScheduling
public class SpringBoot22TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot22TaskApplication.class, args);
        MyQuartz m = new MyQuartz();
    }

}
