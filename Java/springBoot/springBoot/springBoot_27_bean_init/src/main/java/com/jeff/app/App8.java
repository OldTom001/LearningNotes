package com.jeff.app;

import com.jeff.bean.service.BookSerivce;
import com.jeff.config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//方法8:
public class App8 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookSerivce bookservice = ctx.getBean("bookservice", BookSerivce.class);
        bookservice.check();
    }
}
