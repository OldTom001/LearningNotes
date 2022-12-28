package com.jeff.service;

import com.jeff.domain.Book;

import java.util.List;

public interface BookService {
    public Book getById(Integer id);
    public boolean save(Book book);
    public boolean update(Book book);
    public boolean delete(Integer id);
    public List<Book> getAll();
}
