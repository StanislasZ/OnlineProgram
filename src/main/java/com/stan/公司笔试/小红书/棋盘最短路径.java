package com.stan.公司笔试.小红书;

import java.util.Scanner;

public class 棋盘最短路径 {

    static boolean[][] vis;
    static int rows;
    static int cols;
    static int res = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();  //行数
        cols = scanner.nextInt(); //列数
        int k = scanner.nextInt();  //障碍物个数

        vis = new boolean[rows][cols];
        for (int i = 0; i < k; ++i) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            vis[row][col] = true;
        }
        dfs(0, 0, 0);

        System.out.println(res);

    }

    /**
     *
     * @param row
     * @param col
     * @param cnt
     */
    public static void dfs(int row, int col, int cnt) {

        //System.out.println("row = " + row + ", col = " + col + ", cnt = " + cnt);
        //递归终点
        if (row == rows - 1 && col == cols - 1) {
            res = res > 0 ? Math.min(res, cnt) : cnt;
            return;
        }
        if (!canMove(row, col)) return;
        if (res > 0 && cnt > res) return;  //剪纸

        vis[row][col] = true;
        dfs(row + 1, col, cnt + 1);
        dfs(row - 1, col, cnt + 1);
        dfs(row, col + 1, cnt + 1);
        dfs(row, col - 1, cnt + 1);
        vis[row][col] = false;

    }

    //是否能走
    public static boolean canMove(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        return !vis[row][col];
    }

}
