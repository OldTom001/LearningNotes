package com.jeff.mapper;

import com.jeff.domain.Order;
import com.jeff.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

 /*   @Select("SELECT *, o.id oid FROM  ORDERS o, USER u WHERE u.id= o.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.id"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password"),
            @Result(column = "birthday", property = "user.birthday"),

    })
    public List<Order> findAll();*/

    //另一种配置方法
    @Select("SELECT * FROM  ORDERS")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user", //要封装的属性名称
                    column = "uid", //根据哪个字段去查询user表的数据
                    javaType = User.class,//要封装的实体类型
                    //select属性, 查询哪个方法获取数据, 用于封装实体
                    one = @One(select = "com.jeff.mapper.UserMapper.findById")
            )

    })
    public List<Order> findAll();

    @Select("SELECT * FROM ORDERS WHERE uid = #{uid}")
    public List<Order> findByUid(int uid);
}
