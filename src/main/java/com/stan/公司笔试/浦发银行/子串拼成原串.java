package com.stan.公司笔试.浦发银行;

import java.util.Scanner;

public class 子串拼成原串 {

    /*
        给一个字符串，是否存在子串 ,重复多次可以拼接出此原字符串
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int N = str.length();
        System.out.println(new 子串拼成原串().process2(str, N));

    }

    /**
     * 若存在，则周期为T
     * str[0,N)  和 str[T, T+N) 必相同
     * @param str
     * @param N
     * @return
     */
    public boolean process(String str, int N) {
        if (N <= 1) return false;
        String dual = str + str;
        for (int i = 1; i < N; ++i) {
            if (dual.substring(i, i + N).equals(str)) {
                System.out.println("子串为" + dual.substring(0, i));
                return true;
            }
        }
        return false;
    }

    /**
     * 思路同上，
     * 改为直接调用indexOf方法
     * @param str
     * @param N
     * @return
     */
    public boolean process2(String str, int N) {
        if (N <= 1) return false;
        return (str + str).indexOf(str, 1) != N;
    }
}
