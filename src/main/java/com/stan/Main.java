package com.stan;

import java.util.concurrent.Semaphore;

public class Main implements   Runnable{
    public static void main(String[] args) throws InterruptedException{
        Semaphore semAB=new Semaphore(0);
        Semaphore semBC=new Semaphore(0);
        Semaphore semCA=new Semaphore(1);
        Thread threadA=new Thread(new Main(semCA,semAB,semCA,"A"));
        Thread threadB=new Thread(new Main(semAB,semBC,semCA,"B"));
        Thread threadC=new Thread(new Main(semBC,semCA,semCA,"C"));
        threadA.start();
        threadB.start();
        threadC.start();
       // Thread.sleep(5000);
        Thread.yield();
    }

    private Semaphore semAB;
    private Semaphore semBC;
    private Semaphore semCA;
    private String str;

    public Main(Semaphore semAB, Semaphore semBC, Semaphore semCA, String str) {
        this.semAB = semAB;
        this.semBC = semBC;
        this.semCA = semCA;
        this.str = str;
    }

    public void run() {
        int cnt=10;
        while (cnt>=1){
            try{
                semAB.acquire();
            }catch (InterruptedException e){

            }

            System.out.print(str);
            cnt--;
            semBC.release();
        }

    }
//    private String str;
//    private Semaphore sem1;
//    private
//    public Main(String str){
//        this.str=str;
//    }
//    public void run(){
//
//    }
}
