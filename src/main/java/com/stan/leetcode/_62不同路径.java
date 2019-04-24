package com.stan.leetcode;

public class _62不同路径 {
    public static void main(String[] args) {

        System.out.println(new Solution_62().uniquePaths(23 ,12));
    }
}
class Solution_62 {

    int cnt = 0;

    public int uniquePaths(int m, int n) {

//        dfs(0, 0, m, n);
//        return cnt;

        int[][] dp = new int[m][n];
        dp[0][0] = 1; //特殊情况
        for (int i = 1; i < m; i++)
            dp[i][0] = 1;
        for (int j = 1; j < n; j++)
            dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    public void dfs(int row, int col, int m, int n) {

        if (row == m - 1 && col == n - 1) {
            cnt++;
            return;
        }
        if (canMove(row, col + 1, m, n)) dfs(row, col + 1, m, n);
        if (canMove(row + 1, col, m, n)) dfs(row + 1, col, m, n);

    }

    public boolean canMove(int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) return false;
        return true;

    }
}