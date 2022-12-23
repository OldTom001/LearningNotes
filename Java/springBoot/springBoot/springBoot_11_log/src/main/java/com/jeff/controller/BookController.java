package com.jeff.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

//    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    //做get请求
    @GetMapping
    public String getById(){
        System.out.println("springBoot is running...");

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return "springBoot is running...";
    }
}
