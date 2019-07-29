package com.stan.leet_week_game;

public class _1137第N个泰波那契数 {

    /*
        泰波那契序列 Tn 定义如下： 

        T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

        给你整数 n，请返回第 n 个泰波那契数 Tn 的值。


     */


    public int tribonacci(int n) {
        if (n <= 1) return n;
        else if (n == 2) return 1;
        else {
            int a = 0;
            int b = 1;
            int c = 1;
            for (int i = 2; i < n; i++) {
                int temp1 = a;
                int temp2 = b;
                a = b;
                b = c;
                c = temp1 + temp2 + c;
            }
            return c;
        }
    }
}
