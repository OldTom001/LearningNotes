package com.jeff.controller;

import com.jeff.controller.utils.R;
import com.jeff.domain.Book;
import com.jeff.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
@EnableCaching
public class BookController {

        @Autowired
        private BookService bookService;

        @GetMapping
        public R getAll(){
            return new R(true, bookService.getAll());
        }

        @PostMapping
        public R save(@RequestBody Book book) throws IOException {
            if("123".equals(book.getName())) throw new IOException();//拒绝存入name为123的记录
            boolean flag = bookService.save(book);
            return new R(flag , flag ? "添加成功^_^" : "添加失败-_-!");
        }

        //修改, 使用put提交
        @PutMapping
        public R update(@RequestBody Book book){
            return new R(bookService.update(book));
        }

        @DeleteMapping("{id}")
        public R delete(@PathVariable Integer id){
            return new R(bookService.delete(id));
        }

        @GetMapping("{id}")
        public R getById(@PathVariable Integer id){
            Book book = bookService.getById(id);
            boolean flag = book == null ? false : true;
            return new R(flag, book);
        }

/*        @GetMapping("{currentPage}/{pageSize}")
        public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
            IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
            //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
            if( currentPage > page.getPages()){
                page = bookService.getPage((int)page.getPages(), pageSize);
            }
            return new R(null!=page, page);
        }*/
}
