package com.stan.lintcode;

public class _77最长公共子序列 {


    /**
     * dp
     * dp[i][j]表示 A在[0, i-1],B在[0,j-1]取子序列能够取到的最大长度
     * 注意：A不一定要取到i-1位，B不一定要取到j-1位
     * @param A
     * @param B
     * @return
     */
    public int longestCommonSubsequence(String A, String B) {

        int a_len = A.length();
        int b_len = B.length();
        int max = 0;

        int[][] dp = new int[a_len + 1][b_len + 1];

        for (int i = 1; i <= a_len; i++) {
            for (int j = 1; j <= b_len; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
