package com.stan.java部分.多线程.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;


public class _1114按序打印 {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable runnable = () -> {
            return;
        };
        Thread a = new Thread(() -> {
            while (true) {
                try {
                    foo.first(runnable);
                } catch (Exception e) {

                }
            }
        }
        );
        Thread b = new Thread(() -> {
            try {
                foo.second(runnable);
            } catch (Exception e) {

            }
        }
        );
        Thread c = new Thread(() -> {
            try {
                foo.third(runnable);
            } catch (Exception e) {

            }
        }
        );
        c.start();
        a.start();
        b.start();
        Thread.sleep(5000);
    }


}

/**
 * 信号量实现
 */
class Foo {
    Semaphore semAB;
    Semaphore semBC;

    public Foo() {
        semAB = new Semaphore(0);
        semBC = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        System.out.println('a');
        printFirst.run();
        semAB.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        semAB.acquire();
        printSecond.run();
        System.out.println('b');
        semBC.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semBC.acquire();
        printThird.run();
        System.out.println('c');

    }
}






/**
 * 阻塞队列实现
 */
class Foo2 {

    BlockingQueue<Integer> pbq1 = new ArrayBlockingQueue<>(1);
    BlockingQueue<Integer> pbq2 = new ArrayBlockingQueue<>(1);
    BlockingQueue<Integer> pbq3 = new ArrayBlockingQueue<>(1);


    public Foo2() {
        try {
            pbq1.put(1);
        } catch (InterruptedException e) {

        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        pbq1.take();
        printFirst.run();
        pbq2.put(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        pbq2.take();   //pbq2没有数据的时候执行这句被阻塞，直到能take到元素，才执行下一句
        printSecond.run();
        pbq3.put(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        pbq3.take();
        printThird.run();
        pbq1.put(1);
    }
}