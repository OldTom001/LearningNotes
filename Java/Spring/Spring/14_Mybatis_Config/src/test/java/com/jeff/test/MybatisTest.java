package com.jeff.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeff.domain.User;
import com.jeff.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    //写入测试, Date转换成long(自1970年至今的毫秒数)
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟user
        User user = new User();
        user.setUsername("ceshi");
        user.setPassword("123");
        user.setBirthday(new Date());

        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    //读取测试
    //将数据库中的long转换成Date
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(8);
        System.out.println(user);
/*
        List<User> all = mapper.findAll();
        System.out.println(all);*/

        sqlSession.commit();
        sqlSession.close();
    }

    //分页插件测试
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页参数: 当前页+每页显示的条数
        PageHelper.startPage(2,2);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页: "+pageInfo.getPageNum());
        System.out.println("每页显示条数: "+pageInfo.getPageSize());
        System.out.println("总条数: "+pageInfo.getTotal());
        System.out.println("总页数: "+pageInfo.getPages());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());

        sqlSession.commit();
        sqlSession.close();
    }

}
