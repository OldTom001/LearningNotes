package com.jeff.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.jeff.bean.Cat;
import com.jeff.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(MyImportSelector.class)
public class SpringConfig {
    @Bean
    @ConditionalOnClass(name = "com.jeff.bean.Dog")
    public Cat tom(){
        return new Cat();
    }

    @Bean
    @ConditionalOnClass(name="com.mysql.jdbc.Driver")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
