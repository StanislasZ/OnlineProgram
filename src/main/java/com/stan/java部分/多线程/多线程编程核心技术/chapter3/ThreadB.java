package com.stan.java部分.多线程.多线程编程核心技术.chapter3;

import java.util.Date;

public class ThreadB extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 20; i++) {
                if (Tools.tl.get() == null) {
                    Tools.tl.set(new Date());
                }
                System.out.println("B " + Tools.tl.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
