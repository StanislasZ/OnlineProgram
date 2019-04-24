package com.stan.leetcode;

public class _91解码方法 {
    public static void main(String[] args) {


    }
}
class Solution_91 {
    public int numDecodings(String s) {

        if (s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];   //第i位作为单个数
            }
            if (s.charAt(i - 2) != '0'
                && s.charAt(i - 1) - '0' + 10 * (s.charAt(i - 2) - '0') <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
            if (dp[i] == 0) return 0;
        }
        return dp[len];

    }
}