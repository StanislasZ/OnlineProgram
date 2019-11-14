package com.stan.redis深度历险._04延时队列;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import lombok.Data;
import redis.clients.jedis.Jedis;


public class RedisDelayingQueue<T> {

    @Data
    static class TaskItem<T> {
        String id;
        T msg;
    }
    // fastjson 序列化对象中存在 generic 类型时，需要使用 TypeReference
    private Type TaskType = new TypeReference<TaskItem<T>>(){
    }.getType();

    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<T>();
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        String s = JSON.toJSONString(task);
        System.out.println("s = " + s);
        //塞入延时队列， 5s后add
        //效果就是一开始消费者拿数据，拿到的set为空，5s后才有数据
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            System.out.println("loop.. while");
            //只取一条
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    System.out.println("set为空，sleep...");
                    Thread.sleep(500); //歇会
                } catch (InterruptedException e) {
                    System.out.println("捕获InterruptedException， 跳出while");
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            if (jedis.zrem(queueKey, s) > 0) {
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                this.handleMsg(task.msg);
            }

        }
    }

    public void handleMsg(T msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {


        Jedis jedis = new Jedis("zrylovestan.com", 6379);

        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("codehole" + i);
            }
        });
        Thread consumer = new Thread(() -> queue.loop());

        producer.start();
        consumer.start();
        try {
            producer.join();
            System.out.println("producer 跑完...");
            //等producer run方法结束，继续执行
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {

        }

    }

}
