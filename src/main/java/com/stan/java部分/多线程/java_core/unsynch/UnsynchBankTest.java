package com.stan.java部分.多线程.java_core.unsynch;

public class UnsynchBankTest {

    static final int NACCOUNT = 100;
    static final double INITIAL_BALANCE = 1000;
    static final double MAX_AMOUNT = 1000;
    static final int DELAY = 1000;

    public static void main(String[] args) {

        Bank bank = new Bank(NACCOUNT, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNT; ++i) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    System.out.println("catch InterruptedException");
                }
            };
            Thread t = new Thread(r);
            t.start();
        }

    }
}
