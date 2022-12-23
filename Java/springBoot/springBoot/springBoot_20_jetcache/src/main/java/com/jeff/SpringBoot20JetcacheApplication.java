package com.jeff;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation    //springboot缓存用的是@EnableCaching
@EnableMethodCache(basePackages = "com.jeff")
public class SpringBoot20JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot20JetcacheApplication.class, args);
    }

}
