package com.stan.algorithom.动态规划;

public class 背包问题 {

    /**
     * 0-1 背包二维空间解法
     * 给定一系列物品的重量的和价值，在给定背包可承重量下，选择某些物品装入背包，使得装入背包的价值最大
     * 每个物品，要么取要么不取
     *
     * @param weight： 物品重量数组 (多放一个0在最前面)
     * @param value： 物品价值数组 (多放一个0在最前面)
     * @param vol： 背包可承受重量
     * @return：最大可能的价值
     */
    int zeroOneKnapsackByTwoDimesion(int[] weight, int[] value, int vol) {
        int N = weight.length - 1;  //物品真实数量
        int[][] dp = new int[N + 1][vol + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= vol ; ++j) {
                //当前物品比背包容量还大
                if (weight[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);

            }
        }
        return dp[N][vol];
    }

    /**
     * 0-1 背包一维空间解法
     *
     * @param weight： 物品重量数组 (多放一个0在最前面)
     * @param value： 物品价值数组 (多放一个0在最前面)
     * @param vol： 背包可承受重量
     * @return：最大可能的价值
     */
    public int zeroOneKnapsackByOneDimesion(int[] weight, int[] value, int vol) {

        int N = weight.length - 1;  //物品真实数量;
        int[] dp = new int[vol + 1];

        // 二维情况下 dp[i][j] 只与 dp[i - 1][k] 有关, 其中 k <= j
        // 当dp[i - 1] 计算完之后， 直接在其状态上更新即可, 而且每次都应该从右至左遍历
        // 因为要保证左边状态是上一层保留下来的
        for (int i = 1; i <= N; ++i) {

            // 注意第二层循环逆序
            for (int j = vol; j >= 1; --j) {
                if (weight[i] <= j)
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[vol];

    }

    /**
     * 完全 背包二维空间解法
     * 给定一系列物品的重量的和价值，在给定背包可承重量下，选择某些物品装入背包，使得装入背包的价值最大
     * 每个物品，可以不取，获取取任意个
     * @param weight： 物品重量数组 (多放一个0在最前面)
     * @param value： 物品价值数组 (多放一个0在最前面)
     * @param vol： 背包可承受重量
     * @return：最大可能的价值
     */
    public int completeKnapsackByTwoDimesion(int[] weight, int[] value, int vol) {

        int N = weight.length - 1; //物品真实数量
        int[][] dp = new int[N + 1][vol + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= vol; ++j) {
                //加一层数量循环
                dp[i][j] = dp[i - 1][j];
                //01背包在这里 要么取1个 ，要么不取 ， 取两种情况的最大值
                //完全背包就从0到k个 逐个尝试一遍，取最大值
                for (int k = 0; k <= j / weight[i]; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[N][vol];
    }


    /**
     * 完全 背包一维空间解法
     *
     * @param weight： 物品重量数组 (多放一个0在最前面)
     * @param value： 物品价值数组 (多放一个0在最前面)
     * @param vol： 背包可承受重量
     * @return：最大可能的价值
     */
    public int completeKnapsackByOneDimesion(int[] weight, int[] value, int vol) {

        int N = weight.length - 1; //物品真实数量
        int[] dp = new int[vol + 1];

        // 完全背包，如果利用 01 背包的思路可以将 三重循环 降低为 二重
        // 考虑已经计算得到了前 i - 1 个物品在背包容量 0 ~ vol 的最优解
        // 如果要加入第 i 个物品，显然循环起点应该在 w[i]， 因为如果 w[i] > j, 背包放不进去
        // 即，当 j = 0 ~ w[i] - 1时，加入第 i 个物品的最优解应该与前 i - 1 个物品的解保持一致， 即不放它进去
        // 当 j = w[i] ~ vol 时，背包可以放入第 i 个物品，而且在容量比较大时可以持续放入多个
        // 因此，内循环应该是正序的，因为需要与当前层进行比较
        // 比如，放进 2 个第 i 个商品时，要比较与放入 1 个第 i 个商品哪种更优
        for (int i = 1; i <= N ; ++i) {
            // 第二层正序
            for (int j = weight[i]; j <= vol ; ++j) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[vol];

    }


    public static void main(String[] args) {

        int n = 5, w = 10;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(new 背包问题().zeroOneKnapsackByTwoDimesion(weight, value, w));
        System.out.println(new 背包问题().zeroOneKnapsackByOneDimesion(weight, value, w));
    }

}
