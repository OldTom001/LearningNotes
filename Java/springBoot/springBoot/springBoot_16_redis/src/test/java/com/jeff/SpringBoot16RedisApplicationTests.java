package com.jeff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringBoot16RedisApplicationTests {

    @Test
    void set(@Autowired RedisTemplate redisTemplate) {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",41);
    }
    @Test
    void get(@Autowired RedisTemplate redisTemplate) {
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }
    @Test
    void hset(@Autowired RedisTemplate redisTemplate) {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info","b","bb");
    }
    @Test
    void hget(@Autowired RedisTemplate redisTemplate) {
        HashOperations ops = redisTemplate.opsForHash();
        Object val = ops.get("info", "b");
        System.out.println(val);
    }

}
