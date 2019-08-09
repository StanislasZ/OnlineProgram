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
        //先走完这一步
        vis[curr] = true;
        ++ cnt;
        cost += price[pre][curr];

        //递归终点
        if (cnt == total) {
            cost += price[curr][0];
            res = Math.min(res, cost);
            return ;
        }

        for (int i = 0; i < total; ++i) {
            if (!vis[i]) {
                dfs(curr, i, cnt, total, cost);
                vis[i] = false;

            }
        }

    }
}
