package com.jeff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeff.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//测试MP提供的业务层方法
@SpringBootTest
public class BookServiceTestCase2 {

    @Autowired
    private IBookService ibookService;

    @Test
    void testGetById(){
        System.out.println(ibookService.getById(4));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据");
        book.setName("MP业务层方法测试");
        book.setDescription("测试MP提供的通用业务层方法");
        System.out.println(ibookService.save(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(11);
        book.setType("测试");
        book.setName("更新数据测试");
        book.setDescription("测试数据123");
        System.out.println(ibookService.updateById(book));
    }

    @Test
    void testDelete(){
        System.out.println(ibookService.removeById(2));
    }

    @Test
    void testGetAll(){
        List<Book> bookList = ibookService.list();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<>(2,5);
        ibookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
