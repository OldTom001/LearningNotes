package com.jeff.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@Component("tom")
@ConditionalOnClass(name = "com.jeff.bean.Wolf")
public class Cat {
    public Cat(){
    }

    int age;
    public Cat(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
