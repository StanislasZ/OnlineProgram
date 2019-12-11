package com.stan.java部分.多线程.多线程编程核心技术.chapter3;

import java.util.Date;

public class Run {

    public static void main(String[] args) {

//        try {
//            ThreadA a = new ThreadA();
//            a.start();
//            Thread.sleep(1000);
//            ThreadB b = new ThreadB();
//            b.start();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



        //测试值继承
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("    main中取值 = " + Tools.itl.get());
                Thread.sleep(500);
                if (i == 6) Tools.itl.set(new Date());
            }
            Thread.sleep(1000);
            ThreadA a = new ThreadA();
            a.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
