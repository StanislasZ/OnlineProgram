package com.stan.公司笔试.小马智行;

import java.util.Scanner;

public class 青蛙跳石头 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] color = new int[N];
        for (int i = 0; i < N; ++i) color[i] = scanner.nextInt();

        //dp[i] 表示 跳到第 i 个的最少步数
        int[] dp = new int[N];
        for (int i = 1; i < N; ++i) {
            //从i - 1 过来
            dp[i] = dp[i - 1] + 1;
            //从上个颜色过来
            int j = i - 1;
            while (j >= 0) {
                if (color[j] == color[i]) break;
                -- j;
            }
            if (j >= 0) dp[i] = Math.min(dp[j] + 1, dp[i]);
        }
        System.out.println(dp[N - 1]);

    }
}
