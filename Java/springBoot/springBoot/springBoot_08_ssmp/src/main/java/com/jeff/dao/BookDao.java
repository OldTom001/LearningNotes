package com.jeff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

/*
    //使用的MP的话不需要手写下面的代码
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);*/
}
