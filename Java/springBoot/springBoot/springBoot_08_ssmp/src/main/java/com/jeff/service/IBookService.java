package com.jeff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.domain.Book;

//使用MP提供的业务层方法
public interface IBookService extends IService<Book> {
    //若MP提供的通用方法不能满足需求, 可在此处添加自定义方法
    public IPage<Book> getPage(int currentPage, int pageSize);
    public IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
