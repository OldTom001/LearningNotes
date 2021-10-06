package Annotation01;

import java.lang.reflect.Method;

/*框架类
* 使用注解执行特定的方法
* */
@Pro(className = "Annotation01.Class01", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {

        //1. 解析注解
        //1.1获取本类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2. 获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象, 相当于执行下面的代码, 返回值就是@Pro中给的参数
        /*
            public class ProImp1 implements Pro{
                 public String className() {
                       return "Annotation01.Class01"
                 }

                  public String methodName() {
                        return "show"
                  }
            }
 */
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        //3. 调用注解对象中定义的抽象方法, 获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //4. 执行方法
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
