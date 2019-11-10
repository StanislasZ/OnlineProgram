package com.stan.java部分.多线程.gitbook.java_basic_introduction.yield;

public class YieldTest {

    public static void main(String[] args) {

        YieldThread t1 = new YieldThread("thread-1");
        YieldThread t2 = new YieldThread("thread-2");
        t1.start();
        t2.start();
    }
}

class YieldThread extends Thread {
    public YieldThread(String name) {
        super(name);
    }

    //同步方法
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s ,优先级为 : %d ----> %d\n", this.getName(), this.getPriority(), i);

            if (i == 3) {
                System.out.println("线程让步:");
                Thread.yield();
            }
        }
    }
}

