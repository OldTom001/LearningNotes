package Reflect01;

import Domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo04 {
    /*获取Class对象的三种方式*/
    public static void main(String[] args) throws Exception {
//        1. 获取Class类对戏
        Class personClass = Person.class;
        /*Method[] getMethods()
        Method[] getMethod(String name, Class<?>... parameterTypes)
        Method[] getDeclaredMethods()
        Method[] getDeclaredMethod(String name, Class<?>... parameterTypes)*/
//        获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
//        执行方法
        Person p = new Person();
        eat_method.invoke(p);
//        执行方法
        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p, "饭");
        System.out.println("--------");

        Method[] eat_methods = personClass.getMethods();
        for (Method eatMethod : eat_methods) {
            System.out.println(eatMethod); //包含了父类(Object)的方法
//            获取方法名
            String name = eatMethod.getName();
            System.out.println(name);
//            eatMethod.setAccessible(true); //暴力反射
        }

        System.out.println("--------");
//        获取类名
        String className = personClass.getName();
        System.out.println(className); //Domain.Person
    }
}
