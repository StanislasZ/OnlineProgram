package com.stan.java部分.多线程.多线程编程核心技术.chapter3;

import java.util.Date;

public class ThreadA extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 20; i++) {
                if (Tools.tl.get() == null) {
                    Tools.tl.set(new Date());
                }
//                System.out.println("A " + Tools.tl.get());
                System.out.println("A " + Tools.itl.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
