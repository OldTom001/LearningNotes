package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1. 定义sql语句
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {

        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //1. 定义sql, id自增长赋null, username和password是管理员的, 赋null
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(),
                user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {

        String sql = "delete from user where id =?";
        template.update(sql,id);
/*//        删除数据后重置自增键, 先删除主键, 再重新添加主键
//        ALTER TABLE USER DROP id;
//        ALTER TABLE USER ADD id INT NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;
        String sql2 = "ALTER TABLE USER DROP id";
        template.update(sql2);
        String sql3 = "ALTER TABLE USER ADD id INT NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST";
        template.update(sql3);*/
    }

    @Override
    public User findById(int id) {
        try {
            String sql = "select * from user where id = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, " +
                "address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1. 定义初始化sql
        String sql = "select count(*) from user where 1 = 1 "; //注意最后的空格必须有, 才能拼成合法的sql语句
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        //2. 遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页的参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值, 则拼接sql语句
                sb.append(" and "+ key + " like ? ");////注意前后的空格必须有, 才能拼成合法的sql语句
                params.add("%"+value+"%");// ?对应的值
            }
        }
/*        System.out.println(sb.toString());
        System.out.println(params);*/
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
//        第一个?是开始的索引, 第二个?是查询的记录条数
//        String sql = "select * from user limit ?,?";
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        //2. 遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();

        for (String key : keySet) {
            //排除分页的参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值, 则拼接sql语句
                sb.append(" and "+ key + " like ? ");////注意前后的空格必须有, 才能拼成合法的sql语句
                params.add("%"+value+"%");// ?对应的值
            }
        }
/*        System.out.println(sb.toString());
        System.out.println(params);*/
        sb.append(" limit ?, ? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

}
