package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet") //可以用注解, 也可以在web.xml中配置
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //已在监听器中创建应用上下文对象
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取servletContext, 两种方法
//        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext = this.getServletContext();
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        // 使用自己写的工具类获取应用上下文
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //用Spring提供的工具类获取应用上下文
       WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
