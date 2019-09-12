package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51N皇后 {

    List<List<String>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    char[][] base;
    int[] arr;


    public List<List<String>> solveNQueens(int n) {


        base = new char[n][n];
        arr = new int[n];  //第i行的 第arr[i]列放Queen
        for (int i = 0; i < n; ++i) for (int j = 0; j < n; ++j)
            base[i][j] = '.';
        dfs(0, n);
        return res;
    }


    private void dfs(int row, int n) {

        //递归终点
        if (row == n) {

            List<String> temp = new ArrayList<>();
            for (char[] c : base) temp.add(new String(c));
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isOK(row, col)) {
                arr[row] = col;  //不需要回溯，因为在isOK里，判断条件 i < row
                base[row][col] = 'Q';   //需要回溯
                dfs(row + 1, n);
                base[row][col] = '.';
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
    public static void main(String[] args){
        System.out.println(new _51N皇后().solveNQueens(5));


    }
}
