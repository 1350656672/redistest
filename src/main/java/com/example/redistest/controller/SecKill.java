package com.example.redistest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class SecKill {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Transactional
    @RequestMapping(value = "/seckill")
    public String redis() throws InterruptedException {
        double random = Math.random();
        int uid = (int) (random*1000);
        System.out.println(redisTemplate.keys("*"));

        redisTemplate.setEnableTransactionSupport(true);
        //redisTemplate.watch("sum");
        redisTemplate.multi();

        redisTemplate.exec();
        SetOperations so = redisTemplate.opsForSet();
        ValueOperations vo = redisTemplate.opsForValue();

        System.out.println(redisTemplate.opsForValue().get("sum"));
        vo.set("sum","1");
        System.out.println(vo.get("sum"));


        /*int sum = (int) vo.get("sum");
        if (sum<1){
            System.out.println("已抢完！");
        }else {
            vo.decrement("sum",1);
            so.add("s1",String.valueOf(uid));

            System.out.println("抢到了！");
        }*/
        return "抢";
    }
}
