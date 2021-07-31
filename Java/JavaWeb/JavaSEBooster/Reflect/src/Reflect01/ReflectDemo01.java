package Reflect01;

import Domain.Person;
import Domain.Student;

public class ReflectDemo01 {
    /*获取Class对象的三种方式*/
    public static void main(String[] args) throws ClassNotFoundException {
//        1.
        Class cls = Class.forName("Domain.Person");
        System.out.println(cls);
//        2.
        Class cls2 = Person.class;
        System.out.println(cls2);
//        3.
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
//        比较
        System.out.println(cls == cls2); //true
        System.out.println(cls2 == cls3); //true

        Class s = Student.class;
        System.out.println(cls == s); //false
    }
}
