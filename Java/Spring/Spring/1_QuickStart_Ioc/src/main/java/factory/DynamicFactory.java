package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class DynamicFactory {
    /**
     * 工厂动态方法实例化
     * @return
     */
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
