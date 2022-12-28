package com.jeff;

import com.jeff.config.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookCaseTest {

    @Autowired
    private BookCase bookCase;

    @Test
    public void testBookCase(){
        System.out.println(bookCase);
    }
}
