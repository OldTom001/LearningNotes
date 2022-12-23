package com.jeff.test;

import com.jeff.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //测试修改操作
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",1000,"tom");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?","tom");
    }
    @Test
    public void testQueryAll(){
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accounts);
    }

    @Test
    //测试查询单个对象操作
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "sunwukong");
        System.out.println(account);
    }
    @Test
    //测试查询单个简单数据操作(聚合查询)
    public void testQueryCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
}
