package com.jeff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void get(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("username");
        System.out.println(name);
    }

    @Test
    void set(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("type", "book");
        System.out.println(ops.get("type"));
    }
}
