package com.stan.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树 {
    public static void main(String[] args) {

    }

}

class Solution_96 {


    // 先手写一下数学推导过程，一目了然。
    public int numTrees(int n) {

        if (n < 2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        // dp[n] = f(0) + f(1) +…f(i)…… +f(n) ； f(i)表示以i为root有几种树
        // f(i)：  左边有i-1个结点， 右边有n-i个结点  ；左边有dp[i-1]种排法，右边有dp[n-i]种排法
        // f(i) = dp[i-1]*dp[n-i]
        // 推导出 dp[n] = 累加符号dp[i-1]*dp[n-i] ;i从1到n


        for (int i = 2; i<=n; i++) {

            for (int j = 1; j<=i; j++){
                dp[i] = dp[i] + dp[j-1]*dp[i-j];
            }

        }

        return dp[n];



    }
}
