package com.stan.公司笔试.微众银行;

import java.util.Scanner;

public class 黑白棋 {

    static int[][] matrix;

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        matrix = new int[N][N];
        for (int i = 0; i < N; ++i) for (int j = 0; j < N; ++j)
            matrix[i][j] = scanner.nextInt();

        dfs(N, 0, 0, 0);
        System.out.println(res);

    }

    private static void dfs(int N, int row, int col, int cnt) {

        if (row == N && col == 0) {
            res = Math.min(res, cnt);
            return;
        }
        if (col == N) {
            dfs(N, row + 1, 0, cnt);
            return;
        }

        //没放，直接下一个
        if (matrix[row][col] == 0) {
            dfs(N, row, col + 1, cnt);
            return;
        }
        boolean flag = false;
        if (isSame(N, row, col, row, col + 1)) {
            flag = true;
            int temp = matrix[row][col + 1];
            matrix[row][col + 1] = 0;
            dfs(N, row, col + 1, cnt + 1);
            matrix[row][col + 1] = temp;
        }

        if (isSame(N, row, col, row, col - 1)) {
            flag = true;
            int temp = matrix[row][col - 1];
            matrix[row][col - 1] = 0;
            dfs(N, row, col + 1, cnt + 1);
            matrix[row][col - 1] = temp;
        }

        if (isSame(N, row, col, row + 1, col)) {
            flag = true;
            int temp = matrix[row + 1][col];
            matrix[row + 1][col] = 0;
            dfs(N, row, col + 1, cnt + 1);
            matrix[row + 1][col] = temp;
        }

        if (isSame(N, row, col, row - 1, col)) {
            flag = true;
            int temp = matrix[row - 1][col];
            matrix[row - 1][col] = 0;
            dfs(N, row, col + 1, cnt + 1);
            matrix[row - 1][col] = temp;
        }

        if (flag) {
            //改自己
            int temp = matrix[row][col];
            matrix[row][col] = 0;
            dfs(N, row , col + 1, cnt + 1);
            matrix[row][col] = temp;
        }



    }

    private static boolean isSame(int N, int curr_row, int curr_col, int other_row, int other_col) {
        if (other_row < 0 || other_row >= N || other_col < 0 || other_col >= N) return false;
        if (curr_row < 0 || curr_row >= N || curr_col < 0 || curr_col >= N) return false;

        return matrix[curr_row][curr_col] == matrix[other_row][other_col];

    }
}
