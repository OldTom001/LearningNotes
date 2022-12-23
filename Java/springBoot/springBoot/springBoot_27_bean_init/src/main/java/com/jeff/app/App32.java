package com.jeff.app;

import com.jeff.config.SpringConfig32;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//方法3_2: 通过注解导入xml格式的bean
public class App32 {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig32.class);
        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
