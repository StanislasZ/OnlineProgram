package com.stan.al.动态规划;

public class 背包问题 {

    /**
     * 0-1 背包二维空间解法
     * 给定一系列物品的重量的和价值，在给定背包可承重量下，选择某些物品装入背包，使得装入背包的价值最大
     * 每个物品，要么取要么不取
     *
     * @param weight： 物品重量数组 (多放一个0在最前面)
     * @param value： 物品价值数组 (多放一个0在最前面)
     * @param vol： 背包可承受重量
     * @return
     */
    int zeroOneKnapsackByTwoDimesion(int[] weight, int[] value, int vol) {
        int N = weight.length - 1;  //物品真实数量
        int[][] dp = new int[weight.length][vol + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= vol ; ++j) {
                //当前物品比背包容量还大
                if (weight[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] =
            }
        }


    }

    public static void main(String[] args) {

        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量


    }

}
