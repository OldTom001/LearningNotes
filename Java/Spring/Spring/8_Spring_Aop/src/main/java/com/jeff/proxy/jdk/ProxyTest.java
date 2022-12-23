package com.jeff.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();
        //返回值是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //调用代理对象的任何方法, 实质执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        //返回的是执行实际方法的返回值
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        advice.afterRunning();
                        return invoke;
                    }
                });
        proxy.save();
    }
}
