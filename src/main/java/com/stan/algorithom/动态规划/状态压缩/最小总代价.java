package com.stan.algorithom.动态规划.状态压缩;

import java.util.Arrays;
import java.util.Scanner;

public class 最小总代价 {

    /*
        n个人在做传递物品的游戏,编号为1-n。

        游戏规则是这样的：开始时物品可以在任意一人手上，他可把物品传递给其他人中的任意一位；下一个人可以传递给未接过物品的任意一人。

        即物品只能经过同一个人一次，而且每次传递过程都有一个代价；不同的人传给不同的人的代价值之间没有联系；

        求当物品经过所有n个人后，整个过程的总代价是多少。

        输入格式：

        第一行为n,表示共有n个人（16>=n>=2）；

        以下为n*n的矩阵，第i+1行、第j列表示物品从编号为i的人传递到编号为j的人所花费的代价，特别的有第i+1行、第i列为-1（因为物品不能自己传给自己），其他数据均为正整数(<=10000)。

        (对于50%的数据，n<=11)。

        输出格式：

        一个数，为最小的代价总和。

        输入样例：

        2

        -1 9794

        2724 –1

        输出样例：

        2724

     */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cost[i][j] = scanner.nextInt();
            }
        }

        //每个人只能够被传递一次，
        // 因此使用一个n位二进制数state来表示每个人是否已经被访问过了。
        // 但这还不够，因为从这样的状态中，并不能清楚地知道现在物品在谁 的手中，
        // 因此，需要在此基础上再增加一个状态now，表示物品在谁的手上。

        //dp[state][now]表示每个人是否被传递的状态是state，物品在now的手上的时候，最小的总代价。
        //初始状态为：dp[1<<i][i]=0；表示一开始物品在i手中。
        //所求状态为：min(dp[(1<<n)-1][j]); 0<=j<n
        //状态转移方程是：
        //dp[state][now]=min(dp[pre][t]+dist[now][t])；
        //pre表示的是能够到达state这个状态的一个状态，t能够传递物品给now且只有二进制下第t位与state不同。
        //状态的大小是O((2n)*n)，转移复杂度是O(n)。总的时间复杂度是O((2n)*n*n)。

        int[][] dp = new int[1 << n][n];
        int[] row = new int[n];
        Arrays.fill(row, -1);
        Arrays.fill(dp, row);
        for (int i = 0; i < n; ++i) {
            dp[1 << i][i] = 0;
        }
        int ans = -1;
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j] != -1) {
                    for (int k = 0; k < n; ++k) {
                        //i的低位第k位不是0
                        if ((i & (1 << k)) == 0) {
                            dp[i | (1 << k)][k] = Math.min(dp[i | (1 << k)][k], dp[i][j] + cost[j][k]);
                            if ((i | (1 << k)) == (1 << n) - 1) ans = Math.min(ans, dp[i | (1 << k)][k]);
                        }
                    }
                }
            }
        }
        if (ans != -1) {
            System.out.println(ans);
        }



    }
}
