package com.itheima.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器
 */
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //将Spring应用上下文对象存储到ServletContext域中(需要在web.xml中进行配置)
        servletContext.setAttribute("app", app);
        System.out.println("Spring容器创建完毕..");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
