package com.jeff.test;

import com.jeff.domain.User;
import com.jeff.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//UserMapper注解测试
//多对多查询
public class MyBatisTest4 {
    private UserMapper userMapper;
    @Before
    public void getMapper() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testFindAllUserAndRole(){
        List<User> userList = userMapper.findAllUserAndRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
