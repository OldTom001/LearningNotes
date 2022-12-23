package com.jeff.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//方法2: 配置文件配置包扫描, 注解加载bean
public class App2 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext2.xml");

        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
