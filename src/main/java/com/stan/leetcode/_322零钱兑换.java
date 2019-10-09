package com.stan.leetcode;

public class _322零钱兑换 {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {

        //dp[j] 表示 凑j元 最少几枚
        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; ++j) {
            dp[j] = -1;
            for (int i = 0; i < coins.length; ++i) {
                if (coins[i] > j) continue;
                if (dp[j - coins[i]] == -1) continue;

                dp[j] = dp[j] == -1? dp[j - coins[i]] + 1 : Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount];
    }
}
