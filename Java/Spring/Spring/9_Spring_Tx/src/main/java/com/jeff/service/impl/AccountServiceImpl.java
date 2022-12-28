package com.jeff.service.impl;

import com.jeff.dao.AccountDao;
import com.jeff.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        System.out.println("在两个数据库操作之间制造一个错误, 若两个操作同时失败, 说明事务控制成功; 若第一个操作成功, 说明事务控制失败");
        int i = 1/0;
        accountDao.in(inMan, money);
    }
}
