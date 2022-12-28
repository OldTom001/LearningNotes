package com.itheima.domain;

public class User {
    private String username;
    private int age;
    private String addr;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                "age= '" + age + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
