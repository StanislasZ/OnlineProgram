package com.stan.redis深度历险._11Scan;

import redis.clients.jedis.Jedis;

public class ScanTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("47.98.193.140",6379);

        for (int i = 0; i <= 9999; ++i) {
            if (i % 100 == 0) System.out.println("**" + i);
            jedis.set("key" + i, "" + i);
        }


        jedis.close();

    }
}
