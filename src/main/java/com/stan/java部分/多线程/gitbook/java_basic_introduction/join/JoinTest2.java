package com.stan.java部分.多线程.gitbook.java_basic_introduction.join;


//插队
public class JoinTest2 {
    public static void main(String[] args) throws Exception {
        // 创建线程
        Thread t = new Thread(new EmergencyThread(),"线程一");
        t.start(); // 开启线程
        for (int i = 1; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            if (i == 2) {
                t.join(); // 调用join()方法
            }
            Thread.sleep(500); // 线程休眠500毫秒
        }
    }

}
class EmergencyThread implements Runnable {
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            try {
                Thread.sleep(1000); // 线程休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}