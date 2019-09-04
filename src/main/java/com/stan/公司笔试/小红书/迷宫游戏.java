package com.stan.公司笔试.小红书;

import java.util.Scanner;

public class 迷宫游戏 {

    static int n;
    static boolean[][] vis;
    static int res = 0;

    static int end_row = 0;
    static int end_col = 0;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        vis = new boolean[n][n];

        int start_row = 0;
        int start_col = 0;

        for (int i = 0; i < n; ++i) {
            String s = scanner.next();
            char[] temp = s.toCharArray();
            for (int j = 0; j < n; ++j) {
                if (temp[j] == '#') vis[i][j] = true;
                else if (temp[j] == 'S') {
                    start_row = i;
                    start_col = j;
                } else if (temp[j] == 'E') {
                    end_row = i;
                    end_col = j;
                }
            }
        }
        dfs(start_row, start_col, 0);
        System.out.println(res);

    }

    public static void dfs(int row, int col, int cnt) {

        row = (row + n) % n;
        col = (col + n) % n;
        //递归终点
        if (row == end_row && col == end_col) {
            res = res > 0? Math.min(res, cnt) : cnt;
        }
        if (!canMove(row, col)) return;
        if (res > 0 && cnt > res) return;
        vis[row][col] = true;
        dfs(row + 1, col, cnt + 1);
        dfs(row - 1, col, cnt + 1);
        dfs(row, col + 1, cnt + 1);
        dfs(row, col - 1, cnt + 1);
        vis[row][col] = false;


    }

    public static boolean canMove(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) return false;
        return !vis[row][col];
    }
}
