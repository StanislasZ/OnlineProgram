package com.stan.公司笔试.DJI;

import java.util.Scanner;

public class 爱玩游戏的小J {


    /*
        输入：
        2
        2 2
        10 1
        20 2
        3 4
        10 2
        18 3
        10 2

        输出：
        20
        20
     */

    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();  //case数

        while (T-- > 0) {
            /*
            int N = scanner.nextInt(); //游戏数目
            int X = scanner.nextInt(); //总时间

            int[] cj = new int[N];
            int[] time = new int[N];
            for (int i = 0; i < N; i++) {
                cj[i] = scanner.nextInt();
                time[i] = scanner.nextInt();
            }
            爱玩游戏的小J ai = new 爱玩游戏的小J();
            ai.dfs(0, N,X ,0, cj, time);
            System.out.println(ai.max);
            */

            int N = scanner.nextInt(); //游戏数目
            int X = scanner.nextInt(); //总时间

            int[] cj = new int[N + 1];
            int[] time = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                cj[i] = scanner.nextInt();
                time[i] = scanner.nextInt();
            }
            爱玩游戏的小J ai = new 爱玩游戏的小J();
            System.out.println(ai.dp(cj, time, X));

        }


    }

    /**
     * 动态规划 01背包
     * @param cj
     * @param time
     * @param X : 总时间
     * @return
     */
    public int dp(int[] cj, int[] time, int X) {

        int N = cj.length;
        //dp[i][j] : 只有0到i个游戏，总时间为j 下的 最大成就
        int[][] dp = new int[N][X + 1];

        for (int i = 1; i < N; ++i) {
            for (int j = 1; j <= X ; j++) {

                //如果这个游戏要的时间比当前给的总时间j还大，那就不玩
                if (time[i] > j) dp[i][j] = dp[i - 1][j];
                // 否则，比较玩与不玩的情况
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + cj[i]);
            }
        }
        return dp[N - 1][X];
    }


    /**
     * dfs 时间复杂度不好
     * @param i
     * @param N
     * @param remain
     * @param cnt
     * @param cj
     * @param time
     */
    public void dfs(int i, int N, int remain, int cnt, int[] cj, int[] time) {
        if (i == N) {
            max = Math.max(max, cnt);
            return;
        }
        //要
        if (remain - time[i] >= 0)
            dfs(i + 1, N, remain - time[i], cnt+cj[i], cj, time);
        //不要
        dfs(i + 1, N, remain, cnt, cj, time);

    }
}

