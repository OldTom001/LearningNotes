package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 *操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登陆方法
     * @param loginUser 用户名和密码
     * @return 用户的全部数据, 如果没有查询到, 返回null
     */
    public User login(User loginUser){
        try {
            //1. 编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2. 调用query方法, 将查询结果封装成User对象
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace(); //记录日志
            return null;
        }
    }
}
