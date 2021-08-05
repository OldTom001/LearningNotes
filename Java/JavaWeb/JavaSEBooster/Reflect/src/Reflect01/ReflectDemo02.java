package Reflect01;

import Domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo02 {
    /*获取Class对象的三种方式*/
    public static void main(String[] args) throws Exception {
//        1. 获取Class类对戏
        Class personClass = Person.class;
//        2. 获取成员变量
        Field[] fields = personClass.getFields();
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------");
        Field a = personClass.getField("a");

        Person p = new Person();
        Object value = a.get(p); //获取p对象中的成员变量a的值
        System.out.println("value = " + value);

//        3. 设置值
        a.set(p, "张三"); //将p对象中的成员变量a的值设置为"张三"
        System.out.println(p); //Person类中重写了toString方法, 输出所有成员变量以及对应的值
        System.out.println("========");
//        4. 获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
//        5. 访问私有成员变量需要使用暴力反射
        Field d = personClass.getDeclaredField("d");
//         忽略访问权限修饰符的安全检查
        d.setAccessible(true); //暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
