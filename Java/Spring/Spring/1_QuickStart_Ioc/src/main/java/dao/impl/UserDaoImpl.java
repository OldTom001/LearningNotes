package dao.impl;

import dao.UserDao;
import domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;
    private List<String> strList;
    private List<User> userList;
    private Map<String,User> userMap;
    private Properties properties;
    /**
     * 无参构造方法
     * Spring会默认通过无参构造方法创建对象
     */
    public UserDaoImpl() {
        System.out.println("UserDaoImpl对象通过无参构造方法(默认)创建...");
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * init-method与destroy-method
     */
    public void init(){
        System.out.println("UserDaoImpl对象初始化...");
    }

    public void destroy(){
        System.out.println("UserDaoImpl对象销毁...");
    }

    @Override
    public void save() {
        System.out.println("save running...");
        System.out.println(username+"="+age);
        System.out.println(strList);
        System.out.println(userList);
        System.out.println(userMap);
        System.out.println(properties);
    }

}
