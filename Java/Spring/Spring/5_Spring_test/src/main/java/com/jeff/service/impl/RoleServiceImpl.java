package com.jeff.service.impl;

import com.jeff.dao.RoleDao;
import com.jeff.domain.Role;
import com.jeff.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    //角色查询
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    //角色保存
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

}
