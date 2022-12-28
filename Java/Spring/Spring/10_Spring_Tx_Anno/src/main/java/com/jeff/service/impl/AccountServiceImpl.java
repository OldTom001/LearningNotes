package com.jeff.service.impl;

import com.jeff.dao.AccountDao;
import com.jeff.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(isolation = Isolation.READ_COMMITTED)//也可以写在这里, 表示整个类的方法都被事务控制, 如果类上和方法上都写了, 按照就近原则, 以方法上的为准
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        System.out.println("在两个数据库操作之间制造一个错误, 若两个操作同时失败, 说明事务控制成功; 若第一个操作成功, 说明事务控制失败");
        int i = 1/0;
        accountDao.in(inMan, money);
    }
}
