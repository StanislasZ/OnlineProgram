package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 魔塔 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int D = in.nextInt();  //初始防御
        int[] A = new int[n];  //破防数组
        for (int i = 0; i < n; i++) A[i] = in.nextInt();
        int[] B = new int[n];  //伤害值
        for (int i = 0; i < n; i++) B[i] = in.nextInt();

        boolean[] vis = new boolean[n];

    }
}
