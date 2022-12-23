package com.jeff.controller;


import com.jeff.domain.Book;
import com.jeff.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //做get请求
    @GetMapping
    public String getById(){
        System.out.println("springBoot is running...");
        return "springBoot is running...";
    }

    //做get请求
    @GetMapping("/testJson")
    public Book getJson(){

        Book book = new Book();
        book.setId(1);
        book.setName("springBoot2");
        book.setType("springBoot2");
        book.setDescription("springBoot2");
        return book;
    }
}
