package com.jeff.service;

import com.jeff.dao.UserMapper;
//import com.jeff.dao.impl.UserMapperImpl;
import com.jeff.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
/*        //创建dao层对象, 当前dao层实现是手动编写的
        UserMapperImpl userMapper = new UserMapperImpl();
        List<User> all = userMapper.findAll();
        System.out.println(all);*/

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //插全部
        List<User> all = mapper.findAll();
        System.out.println(all);
        //根据id查一个
        User user = mapper.findById(1);
        System.out.println(user);

    }
}
