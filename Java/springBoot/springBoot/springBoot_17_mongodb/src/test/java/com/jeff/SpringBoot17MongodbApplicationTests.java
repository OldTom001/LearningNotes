package com.jeff;

import com.jeff.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class SpringBoot17MongodbApplicationTests {

    @Test
    void testSave(@Autowired MongoTemplate mongoTemplate) {
        Book book = new Book();
        book.setId(3); //这个id必须设置, 否则mongo认为是0
        book.setName("springbootxxx");
        book.setType("springbootxx");
        book.setDescription("springbootxx");
        mongoTemplate.save(book);
    }

    @Test
    void testFind(@Autowired MongoTemplate mongoTemplate){
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

}
