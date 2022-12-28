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
import java.util.Date;
import java.util.List;

//UserMapper注解测试
public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void getMapper() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("jeff");
        user.setPassword("123");
        user.setBirthday(new Date());
        mapper.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setUsername("杨过");
        user.setPassword("123");
        user.setBirthday(new Date());
        mapper.update(user);
    }

    @Test
    public void testDelete(){
        mapper.delete(11);
    }

    @Test
    public void testFindById(){
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
