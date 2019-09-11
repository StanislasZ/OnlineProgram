package com.stan.leetcode;


public class _52N皇后2 {

    int cnt = 0;
    int[] arr;

    public int totalNQueens(int n) {
        arr = new int[n];  //第i行的 第arr[i]列放Queen
        dfs(0, n);
        return cnt;
    }

    private void dfs(int row, int n) {

        //递归终点
        if (row == n) {
            ++ cnt;
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isOK(row, col)) {
                arr[row] = col;  //不需要回溯，因为在isOK里，判断条件 i < row
                dfs(row + 1, n);
            }
        }
    }

    private boolean isOK(int row, int col) {

        //遍历已存放queen的0到row - 1行，不能和它们冲突
        for (int i = 0; i < row; ++i) {
            if (col == arr[i] || col == arr[i] + i - row || col == arr[i] - i + row)
                return false;
        }
        return true;
    }
}
