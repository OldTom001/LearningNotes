package com.jeff.service;

import com.jeff.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}
