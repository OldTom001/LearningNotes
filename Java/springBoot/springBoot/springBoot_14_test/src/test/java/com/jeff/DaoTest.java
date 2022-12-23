package com.jeff;

import com.jeff.domain.Book;
import com.jeff.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        //不必使用controller, 直接模拟一个book即可
        Book book = new Book();
        book.setName("springboot3");
        book.setType("springboot3");
        book.setDescription("springboot3");
        bookService.save(book);
    }
}
