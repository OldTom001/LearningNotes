package test;

import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    /**
     * 测试scope属性
     */
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);//打印地址,判断userDao1和userDao2是否是同一个对象
        System.out.println(userDao2);
    }

    /**
     * 测试init-method属性和destroy-method属性
     */
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");//先创建对象, 再执行init方法
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        ((ClassPathXmlApplicationContext)app).close(); //手动关闭容器, 可以看到destroy方法的执行; 自动关闭看不到
    }

    /**
     * 测试bean的三种实例化方法
     */
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
    }
}
