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

            int[] dp = new int[n];  //dp[i] 为 0到i的最长子序列的长度, 且必须取到第i个数
            int[] sum = new int[n];  //dp[i]对应的和为 sum[i]

            dp[0] = 1;
            sum[0] = nums[0];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    dp[i] = 1;
                    sum[i] = nums[i];
                    if (nums[i] > sum[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            sum[i] = sum[j] + nums[i];
                        } else if (dp[j + 1] == dp[i]) {
                            sum[i] = Math.min(sum[i], sum[j] + nums[i]);
                        }
                    }
                }
                //System.out.println("dp[" + i + "] = "  + dp[i] + ", sum[" + i + "] = " +sum[i]);
            }

            int res = 0;
            for (int i = 0; i < n; ++i) res = Math.max(res, dp[i]);
            System.out.println(res);
        }
    }
}
