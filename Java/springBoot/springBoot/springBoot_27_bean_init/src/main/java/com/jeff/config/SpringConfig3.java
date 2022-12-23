package com.jeff.config;

import com.jeff.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.jeff.bean","com.jeff.config"})
public class SpringConfig3 {
    @Bean
    public DogFactoryBean dog(){
        return new DogFactoryBean();
    }
}
