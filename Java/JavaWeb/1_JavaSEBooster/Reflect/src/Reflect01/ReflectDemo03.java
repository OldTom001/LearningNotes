package Reflect01;

import Domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo03 {
    /*获取Class对象的三种方式*/
    public static void main(String[] args) throws Exception {
//        1. 获取Class类对戏
        Class personClass = Person.class;
//        /*Constructor<?>[]	getConstructors()
//          Constructor	getConstructor(Class<?>... parameterTypes)
//          Constructor<?>[]	getDeclaredConstructors()
//          Constructor	getDeclaredConstructor(Class<?>... parameterTypes)*/
//        2. 获取构造方法
        Constructor constructor1 = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor1);
//        3. 创建对象
        Object person1 = constructor1.newInstance("张三", 23);
        System.out.println(person1);
        System.out.println("--------");

        Constructor constructor2 = personClass.getConstructor();
        System.out.println(constructor2);

        Object person2 = constructor2.newInstance();
        System.out.println(person2);
        System.out.println("--------");

//        4. 绕过构造方法, 直接用类对象创建对象.
        Object o = personClass.newInstance();

/*//        如果访问私有构造方法需要设置暴力反射
        Constructor constructor3 = personClass.getDeclaredConstructor();
//        5. 暴力反射
        constructor3.setAccessible(true);*/
    }
}
