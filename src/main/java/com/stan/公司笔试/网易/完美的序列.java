package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 完美的序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) nums[i] = scanner.nextInt();

            int[] dp = new int[n];  //dp[i] 为 0到i的最长子序列的元素和
            dp[0] = nums[0];
            int cnt = 1;
            int res = 1;
            for (int i = 1; i < n; ++i) {
                if (nums[i] >= dp[i - 1]) {
                    dp[i] = dp[i - 1] + nums[i];
                    ++ cnt;
                    res = Math.max(res, cnt);
                } else {
                    dp[i] = nums[i];
                    cnt = 1;
                }

            }
            System.out.println(res);


        }
    }

}
