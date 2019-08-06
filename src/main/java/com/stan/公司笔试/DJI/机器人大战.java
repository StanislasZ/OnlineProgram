package com.stan.公司笔试.DJI;

import java.util.Scanner;

public class 机器人大战 {

    private static int[][] pass;
    private static boolean[] vis;
    private static int rlt;
    private static int N;
    private static int P;
    private static int C;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            rlt = Integer.MAX_VALUE;
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


            //第0个点到第0个点是0， 不通的设为-1
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
            while (a < C) {
                rlt = Integer.MAX_VALUE;
                int target = request[a++];
                dfs(target, 0, 0, 0);
                res = res + rlt;

            }
            System.out.println(res);
        }




    }

    /**
     * dfs + 回溯
     * @param target ：目标位置索引
     * @param pre ： 上个点的索引
     * @param curr： 这个点的索引
     * @param cnt： 已经走过路程之和（不包括pre->curr这段路）
     */
    private static void dfs(int target, int pre, int curr, int cnt) {

        vis[curr] = true;
        cnt = cnt + pass[pre][curr];
        //递归终点
        if (curr == target) {
            rlt = Math.min(rlt, cnt);
            return;
        }

        for (int i = 0; i < N; ++i) {
            //没走过的 且 可以从curr走到i
            if (!vis[i] && pass[curr][i] != -1) {
                dfs(target, curr, i, cnt);
                //回溯
                vis[i] = false;
            }
        }
    }
}
