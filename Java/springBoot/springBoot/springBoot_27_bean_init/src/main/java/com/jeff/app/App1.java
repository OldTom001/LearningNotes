package com.jeff.app;

import com.jeff.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//方法1: 从配置文件加载bean
public class App1 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext1.xml");
/*        Object cat = app.getBean("cat");
        System.out.println(cat);

        System.out.println(app.getBean(Dog.class));
        System.out.println(app.getBean("dataSource"));*/

        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
