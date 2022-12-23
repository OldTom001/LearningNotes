package com.jeff.app;

import com.jeff.config.SpringConfig32;
import com.jeff.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//方法3_3: @Configuration注解的proxyBeanMethods属性
public class App33 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig33.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-------------------------");
        SpringConfig33 springConfig33 = ctx.getBean("springConfig33", SpringConfig33.class);
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
    }
}
