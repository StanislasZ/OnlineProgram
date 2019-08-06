package com.stan.bishi.ByteDance;

import java.util.Scanner;

public class 找零 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        N = 1024 - N;
        System.out.println(new Solution_找零().getNumOfCoin(N));
    }
}

class Solution_找零 {

    public int getNumOfCoin(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; ++i) dp[i] = i;

        int[] coin = new int[]{1, 4, 16, 64};
        for (int i = 1; i <= N; ++i) {
            for (int j = coin.length - 1; j >= 0; --j) {
                if (i - coin[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        for (int ele : dp) System.out.print(ele+ " ");
        return dp[N];
    }
}
