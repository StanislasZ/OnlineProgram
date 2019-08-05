package com.stan.al.bishi.DJI;

import java.util.Scanner;

public class 机器人大战 {

    private static int[][] pass;
    private static boolean[] vis;
    private static int rlt = Integer.MAX_VALUE;
    private static int N;
    private static int P;
    private static int C;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();   //路标的数目
        P = scanner.nextInt();   //通路的条数
        C = scanner.nextInt();  //测几次
        pass = new int[N][N];

        for (int i = 0; i < P; ++i) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int T = scanner.nextInt();
            pass[A][B] = T;
            pass[B][A] = T;
        }

        int[] request = new int[C];
        for (int i = 0; i < C; ++i) {
            request[i] = scanner.nextInt();
        }


        //第0个点到第0个点是0， 不通的设为int最小值
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i != j && pass[i][j] == 0) {
                    pass[i][j] = -1;
                }
            }
        }

        vis = new boolean[N];


        int res = 0;
        int a = 0;
        int min = Integer.MAX_VALUE;
        while (a < C) {
            rlt = Integer.MAX_VALUE;
            int target = request[a++];

            dfs(target, 0, 0, 0);

            res = res + rlt;







        }
        System.out.println(res);

    }

    private static void dfs(int target, int pre, int curr, int cnt) {
        //递归终点
        if (curr == target) {
            vis[curr] = true;
            if (pass[pre][curr] != -1)

                rlt = Math.min(rlt, cnt + pass[pre][curr]);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (!vis[i]) {
                vis[i] = true;
                if (pass[pre][i] == -1) {
                    return;
                } else {
                    dfs(target, curr, i, cnt + pass[pre][curr]);
                    //回溯
                    vis[i] = false;
                }
            }
        }
    }
}
