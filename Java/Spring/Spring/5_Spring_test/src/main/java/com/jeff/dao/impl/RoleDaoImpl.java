package com.jeff.dao.impl;

import com.jeff.dao.RoleDao;
import com.jeff.domain.Role;
import com.jeff.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //角色查询, 返回所有角色
    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    //角色保存
    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null,role.getRoleName(),role.getRoleDesc());//主键自增, 不需要赋值
    }

    //查询user对应的角色, 做用户查询时调用
    @Override
    public List<Role> findRoleByUserId(User user) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ? ", new BeanPropertyRowMapper<Role>(Role.class), user.getId());
        return roles;
    }

}
