package com.jeff;

import com.jeff.bean.CartoonCatAndMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


//@SpringBootApplication
//    @SpringBootConfiguration
//        @Configuration//标记为bean+代理
//            @Component
//        @Indexed//加速启动
//    @EnableAutoConfiguration
//        @AutoConfigurationPackage
//            @Import({Registrar.class})//重点
//        @Import({AutoConfigurationImportSelector.class})//重点
//    @ComponentScan //包扫描



@SpringBootApplication
//@Import(CartoonCatAndMouse.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }

        CartoonCatAndMouse catAndMouse = context.getBean(CartoonCatAndMouse.class);
        catAndMouse.play();
    }
}
