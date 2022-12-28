package com.jeff.service;

import com.jeff.domain.User;

import java.util.List;

public interface UserService {
    public List<User> list();

    void save(User user, long[] roleIds);

    void del(long userId);

    User login(String username, String password);
}
