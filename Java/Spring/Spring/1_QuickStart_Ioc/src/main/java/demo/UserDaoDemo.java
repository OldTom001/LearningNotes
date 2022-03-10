package demo;

import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        //使用类加载路径
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml"); ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用文件磁盘路径
        ApplicationContext app = new FileSystemXmlApplicationContext("C:\\develop\\LearningNotes\\Java\\Spring\\Spring\\1_QuickStart_Ioc\\src\\main\\resources\\applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
