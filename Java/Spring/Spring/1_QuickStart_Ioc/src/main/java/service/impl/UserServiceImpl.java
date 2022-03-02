package service.impl;

import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class UserServiceImpl implements UserService {

    /**
     * 不使用依赖注入, 需要再获取一次对象, 重复创建了Spring容器
     */
/*    @Override
    public void save() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }*/

    private UserDao userDao;

    public UserServiceImpl() {
    }

    /**
     * 带参构造方法, 可用于构造方法注入
     * @param userDao
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 使用set依赖注入, 不需要再手动获取dao层的对象
     */
/*    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }*/

    @Override
    public void save() {
        userDao.save();
    }
}
