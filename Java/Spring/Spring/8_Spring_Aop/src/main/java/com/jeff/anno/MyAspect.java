package com.jeff.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(* com.jeff.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强");
    }

    @AfterReturning("execution(* com.jeff.anno.*.*(..))")
    public void afterReturning(){
        System.out.println("后置增强");
    }

    //ProceedingJoinPoint: 正在执行的连接点 == 切点
    @Around("execution(* com.jeff.anno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }
    @AfterThrowing("execution(* com.jeff.anno.*.*(..))")
    public void  afterThrowing(){
        System.out.println("异常抛出增强");
    }

    @After("MyAspect.poincut()") //使用切点表达式
    public void after(){
        System.out.println("最终增强");
    }


    //定义切点表达式
    @Pointcut("execution(* com.jeff.anno.*.*(..))")
    public void poincut(){

    }
}
