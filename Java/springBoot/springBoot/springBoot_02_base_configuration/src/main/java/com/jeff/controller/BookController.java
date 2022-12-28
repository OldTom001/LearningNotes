package com.jeff.controller;


import com.jeff.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country1;

    @Value("${users2[1].name}")
    private String username2;

    @Value("${users3[0].name}")
    private String username3;

    @Value("${likes[1]}")
    private String likes;

    @Value("${server.port}")
    private String port;

    @Value("${center.dataDir}")
    private String dataDir;

    @Value("${lesson}")
    private String lesson;

    //读取yml中的全部数据
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String readYml(){
        System.out.println("country: " + country1);
        System.out.println("username2: " + username2);
        System.out.println("username3: " + username3);
        System.out.println("likes: " + likes);
        System.out.println("port: " + port);
        System.out.println("dataDir: " + dataDir);
        System.out.println("lesson: " + lesson);
        System.out.println("---------------------------");
        System.out.println("使用Environment读取全部数据: ");
        System.out.println(env.getProperty("users3[0].name"));
        System.out.println("---------------------------");
        System.out.println("读取yaml对象:");
        System.out.println(myDataSource);
        return "springBoot is running...";
    }
}
