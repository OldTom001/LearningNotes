package com.jeff.app;

import com.jeff.bean.Cat;
import com.jeff.bean.Mouse;
import com.jeff.config.SpringConfig5;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//方法5: 编程注册bean
public class App5 {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext类下有register相关方法, 但是ApplicationContext接口下没有, 因此需要调整
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig5.class);
        //上下文容器对象已经初始化完毕后，手工加载bean
        ctx.register(Mouse.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-----------------------------------");
        ctx.registerBean("tom", Cat.class,0);
        ctx.registerBean("tom", Cat.class,1);
        ctx.registerBean("tom", Cat.class,2);
        System.out.println(ctx.getBean(Cat.class));
    }
}
