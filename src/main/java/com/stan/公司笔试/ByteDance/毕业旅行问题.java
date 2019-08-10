package com.stan.公司笔试.ByteDance;

import java.util.Scanner;

public class 毕业旅行问题 {
    private int res = Integer.MAX_VALUE;
    private int[][] price;
    private boolean[] vis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        毕业旅行问题 solution = new 毕业旅行问题();

        solution.price = new int[n][n];
        solution.vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                solution.price[i][j] = scanner.nextInt();
            }
        }
        solution.dfs(0,0, 0, n, 0);
        System.out.println(solution.res);

        System.out.println(solution.dp(n));


        System.out.println(2 >> -1);
        System.out.println(4 >> -1);


    }

    /**
     * dp[i][j]
     * @param n
     * @return
     */
    public int dp(int n) {
        int V = 1 << (n - 1);
        int[][] dp = new int[n][V];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = price[i][0];  //初始化, 起点到每个城市的距离
        }

        for (int j = 1; j < V; ++j) {
            for (int i = 0; i < n; ++i) {

                dp[i][j] = 100000;
                //低i-1位是否为1
                System.out.println("j = " + j + ", i = " + i + ", j >> (i - 1) = " +(j >> (i-1)));
                if (((j >> (i-1)) & 1) == 1) {  //已经去过i这个城市
                    continue;
                }
                //遍历所有去过的城市，从他们到i，取最小值
                for (int k = 1; k < n; ++k) {
                    //j的二进制从右边数第k - 1位 为 1
                    if(((j >> (k-1)) & 1) == 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j ^ (1 << (k - 1))] + price[i][k]);
                    }
                }
            }
        }
        printDp(dp);
        return  dp[0][(1 << (n - 1)) - 1];
    }

    private void printDp(int[][] dp) {
        int n = dp.length;

        System.out.printf("%10d",0);
        for(int j = 0;j < 1 << (n - 1) ;j++){
            System.out.printf("%10d",j);
        }
        System.out.println();
        for(int i = 0;i < n;i++){
            System.out.printf("%10d",i);
            for(int j = 0;j < 1 << (n - 1) ;j++){
                if(dp[i][j] == 0x7ffff) dp[i][j] = -1;
                System.out.printf("%10d",dp[i][j]);
            }
            System.out.println();
        }
    }





    /**
     * 深度优先搜索，加boolean数组记忆走过的城市，通过50%
     * @param pre: 上个点
     * @param curr: 当前点
     * @param cnt: 已经走过的城市数量（不包括当前点）
     * @param total: 城市总数
     * @param cost: 已经花费的钱（不包括上个点到这个点的花费）
     */
    public void dfs(int pre, int curr, int cnt,int total, int cost) {
        cost += price[pre][curr]; //加上pre->curr这段费用
        //递归终点
        if (++cnt == total) {
            res = Math.min(res, cost + price[curr][0]);
            return ;
        }
        for (int i = 1; i < total; ++i) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(curr, i, cnt, total, cost);
                vis[i] = false;  //回溯
            }
        }
    }
}
