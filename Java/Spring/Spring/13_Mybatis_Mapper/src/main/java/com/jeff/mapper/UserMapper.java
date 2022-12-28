package com.jeff.mapper;

import com.jeff.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}
