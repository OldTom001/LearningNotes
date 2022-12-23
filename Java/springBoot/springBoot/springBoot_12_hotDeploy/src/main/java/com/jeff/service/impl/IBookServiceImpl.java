package com.jeff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.dao.BookDao;
import com.jeff.domain.Book;
import com.jeff.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//使用MP提供的业务层方法
@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    //可在此处添加自定义方法
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize){
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        IPage page = new Page(currentPage, pageSize);

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        return bookDao.selectPage(page, lqw);
    }
}
