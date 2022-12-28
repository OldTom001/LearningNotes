package com.jeff.dao.impl;

import com.jeff.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("test save running...");
    }
}
