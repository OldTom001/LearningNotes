package com.jeff;

import com.jeff.service.SendMailService;
import com.jeff.service.impl.SendMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot23MaiilApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot23MaiilApplication.class, args);
    }
}
