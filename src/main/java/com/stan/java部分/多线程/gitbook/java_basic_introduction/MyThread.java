package com.stan.java部分.多线程.gitbook.java_basic_introduction;

public class MyThread extends Thread{

    private String name;

    MyThread(String name) {
        this.name = name;
    }

    // 2、覆盖Thread类中的run方法。
    public void run() {
        for (int x = 0; x < 5; x++) {
            System.out.println(name + "...x=" + x + "...ThreadName="
                    + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        // 3、直接创建Thread的子类对象创建线程。
        MyThread d1 = new MyThread("黑马程序员");
        MyThread d2 = new MyThread("中关村在线");
        // 4、调用start方法开启线程并调用线程的任务run方法执行。
        d1.start();
        d2.start();
        for (int x = 0; x < 5; x++) {
            System.out.println("x = " + x + "...over..."
                    + Thread.currentThread().getName());
        }
    }
}
