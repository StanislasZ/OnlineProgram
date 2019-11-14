package com.stan.redis深度历险._07布隆过滤器;

import redis.clients.jedis.Jedis;

public class BloomTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("zrylovestan.com", 6380);

        jedis.del("codehole");
        jedis.zadd("codehole", 10, "stantheman");
        jedis.zadd("codehole", 5, "tuge");

        System.out.println("type = " + jedis.type("codehole"));
        System.out.println("zset中元素的个数："+jedis.zcard("codehole"));
        System.out.println("zset中分值在1-100之间的元素的个数："+jedis.zcount("codehole", 1, 100));
    }
}
