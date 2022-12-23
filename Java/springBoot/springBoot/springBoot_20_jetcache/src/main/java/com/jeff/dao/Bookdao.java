package com.jeff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Bookdao extends BaseMapper<Book> {
}
