package com.jeff.service.impl;

import com.alicp.jetcache.anno.*;
import com.jeff.dao.Bookdao;
import com.jeff.domain.Book;
import com.jeff.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private HashMap<Integer, Book> cache = new HashMap<>();

    @Autowired
    private Bookdao bookDao;

    //使用springBoot提供的缓存
    @Override
    @Cached(name="book_",key="#id",expire = 3600,cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }


/*    @Override
    //模拟缓存
    public Book getById(Integer id) {

        Book book = cache.get(id);
        if(book == null){
            book = bookDao.selectById(id);
            cache.put(id, book);
            return book;
        }
        return cache.get(id);
    }*/




    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    @CacheUpdate(name="book_", key="book.id", value = "#book")
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
