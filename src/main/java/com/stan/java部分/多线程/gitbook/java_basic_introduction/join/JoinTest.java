package com.stan.java部分.多线程.gitbook.java_basic_introduction.join;


//线程插队
public class JoinTest {


    /*
        当在某个线程中调用其他线程的join()方法时，
        调用的线程将被阻塞，
        直到被join()方法加入的线程执行完成后它才会继续运行

        让别人插个队

        场景？
            线程2需要的数据 必须等线程1结束了 才是正确的
     */

    public static void main(String[] args) {

        Worker worker1 = new Worker("work-1");
        Worker worker2 = new Worker("work-2");

        worker1.start();
        System.out.println("启动线程1");
        try {
            worker1.join();
            //等worker1这个线程run方法执行结束，main才会继续
            System.out.println("启动线程2");
            worker2.start();
            worker2.join();
            //等worker2这个线程run方法执行结束，main才会继续
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程继续执行");
    }
}
class Worker extends Thread {

    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work in " + getName());
    }
}