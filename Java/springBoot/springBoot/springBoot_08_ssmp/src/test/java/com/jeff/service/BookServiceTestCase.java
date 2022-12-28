package com.jeff.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeff.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//测试全部自定义的业务层方法
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据44444");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        System.out.println(bookService.save(book));
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(11);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        System.out.println(bookService.update(book));
    }
    @Test
    void testDelete(){
        System.out.println(bookService.delete(3));
    }

    @Test
    void testGetAll(){
        List<Book> bookList = bookService.getAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
