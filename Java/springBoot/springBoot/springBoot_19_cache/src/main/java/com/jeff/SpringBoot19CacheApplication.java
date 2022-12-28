package com.jeff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBoot19CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot19CacheApplication.class, args);
    }

}
