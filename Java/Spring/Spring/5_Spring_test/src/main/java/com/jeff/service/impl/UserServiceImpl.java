package com.jeff.service.impl;

import com.jeff.dao.RoleDao;
import com.jeff.dao.UserDao;
import com.jeff.domain.User;
import com.jeff.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    //用户查询, 返回用户列表
    //需要查两张表: 用户表得到基本信息, 关系表得到角色信息
    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for(User user : userList){
            user.setRoles(roleDao.findRoleByUserId(user));
        }
        return userList;
    }

    //保存新添加的用户
    @Override
    public void save(User user, long[] rolesIds) {
        //第一步, 向sys_user表中存储数据
        long userId = userDao.save(user);
        //第二步, 向sys_user_role表中存储多条数据
        userDao.saveUserRoleRel(userId, rolesIds);
    }

    //删除用户, 先删除关系表, 再删除用户表, 顺序不能颠倒(因为关系表中是外键)
    @Override
    public void del(long userId) {
        userDao.delUserRoleRel(userId);
        userDao.del(userId);
    }

    //用户登录
    @Override
    public User login(String username, String password) {
        //try catch处理查询结果为null时的异常
        try {
            User user = userDao.findUserByUsernameAndPassword(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
