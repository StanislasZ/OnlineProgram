package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 怪兽距离 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String s = in.nextLine();
            for (int j = 0; j < m; ++j) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
//        System.out.println("((((");
        int[][] res = new int[n][m];
        for (int i = 0; i < n; ++i) for (int j = 0; j < m; ++j) res[i][j] = Math.max(n, m); //初始化

        //每行左往右刷
        for (int i = 0; i < n; ++i) {
            if (a[i][0] == 0) res[i][0] = 0;
            for (int j = 1; j < m; ++j) {
                res[i][j] = a[i][j] == 0? 0: Math.min(res[i][j - 1] + 1, res[i][j]);
            }
        }
        //每行右往左
        for (int i = 0; i < n; ++i) {
            if (a[i][m - 1] == 0) res[i][m -1] = 0;
            for (int j = m -2; j >= 0; --j) {
                res[i][j] = a[i][j] == 0? 0: Math.min(res[i][j + 1] + 1, res[i][j]);
            }
        }
        //每列上到下
        for (int j = 0; j < m; ++ j) {
            if (a[0][j] == 0) res[0][j] = 0;
            for (int i = 1; i < n; ++i) {
                res[i][j] = a[i][j] == 0? 0: Math.min(res[i - 1][j] + 1, res[i][j]);
            }
        }

        //每列下到上
        for (int j = 0; j < m; ++ j) {
            if (a[n - 1][j] == 0) res[n - 1][j] = 0;
            for (int i = n - 2; i >= 0; --i) {
                res[i][j] = a[i][j] == 0? 0: Math.min(res[i + 1][j] + 1, res[i][j]);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j < m - 1) System.out.print(res[i][j] + " ");
                else System.out.println(res[i][j]);
            }
            //System.out.println();
        }
    }
}
