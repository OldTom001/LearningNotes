package com.jeff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.dao.BookDao;
import com.jeff.domain.Book;
import com.jeff.service.IBookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

//使用MP提供的业务层方法
@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    private Counter counter;

    public IBookServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("用户付费次数：");
    }

    @Override
    //重写MP提供的removeById方法
    public boolean removeById(Serializable id) {
        //每次执行删除业务等同于执行了付费业务
        counter.increment();
        return bookDao.deleteById(id) > 0;
    }

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
