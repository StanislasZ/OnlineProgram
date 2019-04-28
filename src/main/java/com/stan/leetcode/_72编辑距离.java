package com.stan.leetcode;

public class _72编辑距离 {
    public static void main(String[] args) {
        /**
         * 问题1：如果 word1[0..i-1] 到 word2[0..j-1] 的变换需要消耗 k 步，
         * 那 word1[0..i] 到 word2[0..j] 的变换需要几步呢？
         *
         * 答：先使用 k 步，把 word1[0..i-1] 变换到 word2[0..j-1]，消耗 k 步。
         * 再把 word1[i] 改成 word2[j]，就行了。如果 word1[i] == word2[j]，
         * 什么也不用做，一共消耗 k 步，否则需要修改，一共消耗 k + 1 步。
         *
         * 问题2：如果 word1[0..i-1] 到 word2[0..j] 的变换需要消耗 k 步，
         * 那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
         *
         * 答：先经过 k 步，把 word1[0..i-1] 变换到 word2[0..j]，消耗掉 k 步，
         * 再把 word1[i] 删除，这样，word1[0..i] 就完全变成了 word2[0..j] 了。一共 k + 1 步。
         *
         * 问题3：如果 word1[0..i] 到 word2[0..j-1] 的变换需要消耗 k 步，
         * 那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
         *
         * 答：先经过 k 步，把 word1[0..i] 变换成 word2[0..j-1]，消耗掉 k 步，
         * 接下来，再插入一个字符 word2[j], word1[0..i] 就完全变成了 word2[0..j] 了。
         */
    }
}
class Solution_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i][j] 就是 word1[0到i-1] 到word2[0到j-1]
                    //dp[i - 1][j] + 1 :  word1 删除i-1位
                    //dp[i][j - 1] + 1 :  word1加一个
                    //dp[i - 1][j - 1] + 1: 换一个


                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}