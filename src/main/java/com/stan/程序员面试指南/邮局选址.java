package com.stan.程序员面试指南;

import java.util.Scanner;

public class 邮局选址 {


    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int num = scanner.nextInt();
        int[] coor = new int[N];
        for (int i = 0; i < N; ++i) coor[i] = scanner.nextInt();

        //法1 : dfs
//        dfs(-1, coor, 0, 0, num);
//        System.out.println(res);


        //法2 : dp
        System.out.println(new 邮局选址().minDistance(coor, num));

    }

    /**
     * dp
     * @param arr
     * @param num: 要建几个邮局
     * @return
     */
    public int minDistance(int[] arr, int num) {
        int N = arr.length;
        if (arr == null || num < 1 || N < num) return 0;

        int[][] w = new int[N + 1][N + 1];
        //区间必须右边大于左边, j > i
        for (int i = 0; i < N; ++i) for (int j = i + 1; j < N; ++j)
            w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];

        //dp[i][j]表示 在[0-j]建 i+1 个邮局 的最短距离和
        int[][] dp = new int[num][N];
        for (int j = 0; j < N; ++j) dp[0][j] = w[0][j];   //必要初始化


        for (int i = 1; i < num; ++i) {
            for (int j = i + 1; j < N; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + w[k + 1][j]);
                }

            }
        }



        return dp[num - 1][N - 1];

    }





    /**
     * dfs  超时
     * @param pre: 上一个邮局索引
     * @param coor
     * @param cnt： 已经建了几个邮局
     * @param s： 第0个到第pre- 1个地方到邮局的距离之和
     * @param num： 需要建几个邮局
     */
    private static void dfs(int pre, int[] coor, int cnt, int s, int num) {

        //递归终点
        if (res > 0 && cnt > res) return;
        if (cnt == num) {
            //加上最后几个
            for (int i = pre + 1; i < coor.length; ++i) s += (coor[i] - coor[pre]);
            res = res > 0? Math.min(res, s) : s;
            return;
        }

        for (int i = pre + 1; i < coor.length; ++i) {
            int temp = 0;
            for (int j = pre + 1; j < i; ++j)
                temp += pre == -1? coor[i] - coor[j] : Math.min(coor[j]- coor[pre], coor[i] - coor[j]);
            dfs(i, coor, cnt + 1, s + temp, num);
        }
    }
}
