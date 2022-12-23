package com.jeff.app;

import com.jeff.config.SpringConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//方法3: 通过配置类加载bean
public class App3 {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig3.class);
/*        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }*/
        Object dog = app.getBean("dog");
        System.out.println(dog);
    }
}
