package com.jeff;

import com.alibaba.druid.pool.DruidDataSource;
import com.jeff.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class SpringBoot13ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource datasource(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBoot13ConfigurationApplication.class, args);
        //测试自定义bean
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        //测试第三方bean
        DruidDataSource bean1 = ctx.getBean(DruidDataSource.class);
        System.out.println(bean1);
    }
}
