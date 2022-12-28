package com.jeff.dao;

import com.jeff.domain.Role;
import com.jeff.domain.User;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(User user);
}
