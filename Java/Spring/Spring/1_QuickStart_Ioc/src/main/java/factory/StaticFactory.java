package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class StaticFactory {
    /**
     * 工厂静态方法实例化
     * @return
     */
    public static UserDao getUserDao(){
        System.out.println("通过工厂静态方法实例化...");
        return new UserDaoImpl();
    }
}
