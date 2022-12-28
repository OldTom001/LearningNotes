package com.jeff.service.impl;

import com.jeff.dao.Bookdao;
import com.jeff.domain.Book;
import com.jeff.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private Bookdao bookdao;

    @Override
    public void save(Book book) {
        int insert = bookdao.insert(book);
    }
}
