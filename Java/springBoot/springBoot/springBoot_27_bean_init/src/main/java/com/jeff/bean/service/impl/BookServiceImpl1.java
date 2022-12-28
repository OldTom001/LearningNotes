package com.jeff.bean.service.impl;

import com.jeff.bean.service.BookSerivce;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl1 implements BookSerivce {
    @Override
    public void check() {
        System.out.println("book service 1..");
    }
}
