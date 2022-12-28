package com.jeff.mapper;

import com.jeff.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findUserAndRoleAll();

}

