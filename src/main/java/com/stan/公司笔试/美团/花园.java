package com.stan.公司笔试.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 花园 {

    /*
        公园里有N个花园，初始时每个花园里都没有种花，
        园丁将花园从1到N编号并计划在编号为i的花园里恰好种A_i朵花，
        他每天会选择一个区间[L，R]（1≤L≤R≤N）并在编号为L到R的花园里各种一朵花，
        那么园丁至少要花多少天才能完成计划？
     */



    //static int res = 0;
    public static void main(String[] args) {

        Scanner sc = new java.util.Scanner(System.in);
        int N = sc.nextInt();
        int[] target = new int[N];
        for (int i = 0; i < N; ++i) {
            target[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 1; i < N; ++i) {
            if (target[i - 1] > target[i]) {
                cnt += target[i - 1] - target[i];
            }
        }
        System.out.println(cnt + target[N - 1]);

    }

}
