package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserController{
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();

/*        //这里会报空指针异常, 因为service对象是自己创建的而不是从Spring容器中获取的, 没有注入UserDao的对象, save方法中的userDao对象为空
        UserService userService1 = new UserServiceImpl();
        userService1.save();*/
    }
}
