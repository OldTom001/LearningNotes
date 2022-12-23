package com.jeff.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jeff.controller.utils.R;
import com.jeff.domain.Book;
import com.jeff.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService ibookService;

    @GetMapping
    public R getAll(){
        List<Book> bookList = ibookService.list();
        boolean flag = bookList==null? false : true;
        return new R(flag, bookList, flag? "查询成功^_^" : "查询失败-_-!");
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if("123".equals(book.getName())) throw new IOException();//拒绝存入name为123的记录
        boolean flag = ibookService.save(book);
        return new R(flag , flag ? "添加成功^_^" : "添加失败-_-!");
    }

    //修改, 使用put提交
    @PutMapping
    public R update(@RequestBody Book book){
        boolean flag = ibookService.updateById(book);
        return new R(flag, flag ? "更新成功^_^" : "更新失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        boolean flag = ibookService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        Book book = ibookService.getById(id);
        System.out.println("点击编辑进行热部署测试...");
//        System.out.println("点击编辑进行热部署测试...");
//        System.out.println("点击编辑进行热部署测试...");
        boolean flag = book == null ? false : true;
        return new R(flag, book, flag ? "查询成功^_^" : "查询失败-_-!");
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
        IPage<Book> page = ibookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = ibookService.getPage((int)page.getPages(), pageSize);
        }
        boolean flag = page!=null ? true : false;
        return new R(flag, page, flag ? "分页查询成功^_^" : "分页查询失败-_-!");
    }

}
