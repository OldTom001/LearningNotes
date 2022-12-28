package com.jeff.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
