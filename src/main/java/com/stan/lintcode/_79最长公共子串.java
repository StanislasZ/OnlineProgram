package com.stan.lintcode;

public class _79最长公共子串 {
    public int longestCommonSubstring(String A, String B) {


        int a_len = A.length();
        int b_len = B.length();
        int max = 0;

        //dp[i][j] 为 A取前i个，B取前j个，看这两个的LCS长度，各个的最后一个不等，肯定是0了
        int[][] dp = new int[a_len + 1][b_len + 1];


        for (int i = 1; i <= a_len; ++i) {
            for (int j = 1; j <= b_len; ++j) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        return max;




    }
}
