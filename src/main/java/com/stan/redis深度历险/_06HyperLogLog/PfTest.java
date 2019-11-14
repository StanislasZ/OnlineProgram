package com.stan.redis深度历险._06HyperLogLog;

import redis.clients.jedis.Jedis;

public class PfTest {

    public static void main(String[] args) {

        /*
            因为HyperLogLog 提供不精确的去重计数方案
            这里测一下

            第一次： 99次的时候出错
         */

        Jedis jedis = new Jedis("zrylovestan.com",6379);
        for (int i = 0; i < 1000; i++) {
            jedis.pfadd("codehole", "user" + i);
            long total = jedis.pfcount("codehole");
            if (total != i + 1) {
                System.out.printf("%d %d\n", total, i + 1);
                break;
            }
        }
        jedis.close();
    }
}
