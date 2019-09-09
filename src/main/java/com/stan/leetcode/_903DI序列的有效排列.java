package com.stan.leetcode;

public class _903DI序列的有效排列 {

    /*
        我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
        有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：

        如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
        如果 S[i] == 'I'，那么 P[i] < P[i+1]。
        有多少个有效排列？因为答案可能很大，所以请返回你的答案模 10^9 + 7.

        示例：

        输入："DID"
        输出：5
        解释：
        (0, 1, 2, 3) 的五个有效排列是：
        (1, 0, 3, 2)
        (2, 0, 3, 1)
        (2, 1, 3, 0)
        (3, 0, 2, 1)
        (3, 1, 2, 0)
         
        提示：
        1 <= S.length <= 200
        S 仅由集合 {'D', 'I'} 中的字符组成。

     */


    /**
     * 动态规划
     * 参考：https://www.cnblogs.com/grandyang/p/11094525.html
     * @param S
     * @return
     */
    public int numPermsDISequence(String S) {
        int M = 1_000_000_007;
        int n = S.length();
        int res = 0;
        //dp[i][j]为 范围从0到i 最后一个数字为j的不同序列的个数
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j <= i; ++j) {

                //dp[i][j] 从 dp[i - 1][k]而来
                //降   k在[j, i - 1] ,注意j 可以取到
                //升   k在[0, j - 1], 注意j 不可以取到

                int left  = S.charAt(i - 1) == 'D'? j : 0;
                int right = S.charAt(i - 1) == 'D'? i - 1 : j - 1;
                for (int k = left; k <= right; ++k) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] = dp[i][j] % M;
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            res += dp[n][i];
            res = res % M;
        }
        return res;
    }
}
