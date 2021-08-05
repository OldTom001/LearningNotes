package Reflect01;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*框架类*/
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象, 执行任意方法
       /*原来的方法:
        Person p = new Person();
        p.eat();*/

        Properties pro = new Properties();
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //获取配置文件中的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //获取类
        Class<?> cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        //获取方法
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
