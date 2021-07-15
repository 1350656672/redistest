package com.example.redistest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;
import java.util.Set;

@SpringBootTest by b2
//@ImportResource("classpath:beans.xml")

class RedistestApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /*@Autowired
    StringRedisTemplate redisTemplate;*/

    @Test
    /*@Transactional*/
    void contextLoads() {
        double random = Math.random();
        int x = (int) (random*1000);
        System.out.println(x);
        /*redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.exec();*/

        System.out.println(redisTemplate.keys("*"));
        System.out.println(redisTemplate.opsForValue().get("sum"));
        /*redisTemplate.watch("sum");
        redisTemplate.multi();
        redisTemplate.exec();*/
    }

}
