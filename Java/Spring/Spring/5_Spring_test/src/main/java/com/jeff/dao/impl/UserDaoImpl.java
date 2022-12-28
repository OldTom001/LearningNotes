package com.jeff.dao.impl;

import com.jeff.dao.UserDao;
import com.jeff.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //用户查询, 返回所有用户并封装成列表
    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user ", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    //用户保存, 将用户数据保存到sys_user表中, 并返回userId
    //返回的userId用于在sys_user_role表中保存数据
    @Override
    public long save(User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成一个PreparedStatement的组件
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        //获取生成的主键
        long userId = keyHolder.getKey().longValue();
        //jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null,user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return userId;
    }

    //用户保存, 在sys_user_role表中保存userId和roleId
    @Override
    public void saveUserRoleRel(long userID, long[] rolesIds) {
        for(long roleId : rolesIds){
            jdbcTemplate.update("insert into sys_user_role values (?, ?)", userID,roleId);
        }
    }

    //删除用户, 在在sys_user_role根据userId删除数据
    @Override
    public void delUserRoleRel(long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    //删除用户, 在在sys_user根据userId删除数据
    @Override
    public void del(long userId) {
        jdbcTemplate.update("delete  from sys_user where id = ?", userId);
    }

    //根据用户输入的用户名和密码查询sys_user, 并返回查询结果
    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        //抛出查询结果为null时的异常, 在业务层进行处理
        User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?", new BeanPropertyRowMapper<User>(User.class),username, password);
        return user;
    }
}
