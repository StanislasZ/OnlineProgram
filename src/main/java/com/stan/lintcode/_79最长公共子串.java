package com.stan.lintcode;

public class _79最长公共子串 {


    /**
     * dp
     * dp[i][j] 表示 A从[0,i-1]取，B取[0,j-1]取，能够取到的最大长度
     * 且 A必须取到i-1位，B必须取到j-1位
     * @param A
     * @param B
     * @return
     */
    public int longestCommonSubstring(String A, String B) {


        int a_len = A.length();
        int b_len = B.length();
        int max = 0;

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
