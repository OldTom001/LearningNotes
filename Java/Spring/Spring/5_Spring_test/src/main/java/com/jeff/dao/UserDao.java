package com.jeff.dao;

import com.jeff.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    long save(User user);

    void saveUserRoleRel(long userID, long[] rolesIds);

    void delUserRoleRel(long userId);

    void del(long userId);

    User findUserByUsernameAndPassword(String username, String password);
}
