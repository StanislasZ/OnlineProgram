package com.stan.leetcode;

public class _63不同路径 {
    public static void main(String[] args) {


    }
}
class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++)    dp[i][0] = obstacleGrid[i][0] == 1? 0:dp[i - 1][0];
        for (int j = 1; j < dp[0].length; j++) dp[0][j] = obstacleGrid[0][j] == 1? 0:dp[0][j - 1];



        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}