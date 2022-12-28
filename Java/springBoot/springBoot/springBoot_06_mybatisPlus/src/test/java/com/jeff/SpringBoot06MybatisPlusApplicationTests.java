package com.jeff;

import com.jeff.dao.BookDao;
import com.jeff.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot06MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }
    @Test
    void testGetAll(){
        //传入null即可查询全部数据
        List<Book> bookList = bookDao.selectList(null);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}
