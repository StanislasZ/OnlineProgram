package com.stan.java部分.多线程.java_core.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {


    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();   //这个银行就只有这1个锁
        sufficientFunds = bankLock.newCondition();  //这个锁现在就只有这一个condition
    }


    //账户1给账户2转账时， 账户3也不能给账户4转账， 如何改进？
    public void transfer(int from, int to, double amount) throws InterruptedException {

        bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();  //进入等待，等待其他线程来signal当前线程， 同时并把锁释放了！！！这样其他线程才能从阻塞变回正常状态！！
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("   %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }



    }

    public double getTotalBalance() {

        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) sum += a;
            return sum;
        } finally {
            bankLock.unlock();
        }


    }

    public int size() {
        return accounts.length;
    }
}
