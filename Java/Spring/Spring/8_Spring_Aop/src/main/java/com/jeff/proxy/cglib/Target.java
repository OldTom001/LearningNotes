package com.jeff.proxy.cglib;

import com.jeff.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
