package com.jeff.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jeff.domain.Book;
import com.jeff.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService ibookService;

    @GetMapping
    public List<Book> getAll(){
        return ibookService.list();
    }

    @PostMapping
    public boolean save(@RequestBody Book book){
        return ibookService.save(book);
    }

    //修改, 使用put提交
    @PutMapping
    public boolean update(@RequestBody Book book){
        return ibookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return ibookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return ibookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return ibookService.getPage(currentPage, pageSize);
    }

}
