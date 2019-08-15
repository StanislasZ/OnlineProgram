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
        int res = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int k = 0; k < cube[i][j]; ++k) {
                    int cnt = 0;
                    //下
                    if (k == 0) ++ cnt;
                    //上
                    if (k == cube[i][j] - 1) ++ cnt;
                    //前
                    if (i == 0 || cube[i - 1][j] < k + 1) ++ cnt;
                    //后
                    if (i == N - 1 || cube[i + 1][j] < k + 1) ++ cnt;
                    //左
                    if (j == 0 || cube[i][j - 1] < k + 1) ++ cnt;
                    //右
                    if (j == M - 1 || cube[i][j + 1] < k + 1) ++ cnt;
                    res += cnt;
                }
            }
        }
        System.out.println(res);
    }
}
