package com.jeff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//假装这是一个需要临时加载的测试类
public class MsgConfig {
    @Bean
    public String msg(){
        return "bean msg";
    }
}
