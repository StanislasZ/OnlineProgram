package com.stan.公司笔试._360;

import java.util.Scanner;
public class 立方体表面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] cube = new int[N][M];
        for (int i = 0; i < N; ++i) for (int j = 0; j < N; ++j)
            cube[i][j] = scanner.nextInt();

        int res = 2 * N * M;  //初始化为顶+底
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                //前
                res = i == 0? res + cube[i][j] : res + Math.max(0, cube[i][j] - cube[i - 1][j]);
                //后
                res = i == N - 1? res + cube[i][j] : res + Math.max(0, cube[i][j] - cube[i + 1][j]);
                //左
                res = j == 0? res + cube[i][j] : res + Math.max(0, cube[i][j] - cube[i][j - 1]);
                //右
                res = j == M - 1? res + cube[i][j] : res + Math.max(0, cube[i][j] - cube[i][j + 1]);
            }
        }
        System.out.println(res);
    }
}
