package com.jeff.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    //做get请求
    @GetMapping
    public String getById(){
        System.out.println("springBoot is running...4");
        return "springBoot is running...4";
    }
}
