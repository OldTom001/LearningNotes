package com.jeff.dao;

public interface AccountDao {
    public void out(String name, double money);
    public void in(String name, double money);
}
