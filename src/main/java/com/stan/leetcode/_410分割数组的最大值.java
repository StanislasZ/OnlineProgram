package com.stan.leetcode;

public class _410分割数组的最大值 {

    /*
        携程： 任务调度
     */


    public static void main(String[] args) {

        new _410分割数组的最大值().splitArray(new int[]{1, 5,3, 2, 4}, 3);

    }


    /**
     * 二分法
     * @param nums
     * @param m
     * @return
     */
    public int splitArray3(int[] nums, int m) {

        long left = nums[0];
        long right = 0;
        for (int ele : nums) {
            right = right + ele;
            left = left > ele ? left : ele;
        }
        while (left < right) {
            long mid = (left + right)/ 2;
            long temp = 0;
            int cnt = 1;
            for (int ele : nums) {
                temp = temp + ele;
                if (temp > mid) {
                    temp = ele;
                    ++ cnt;
                }
            }
            if (cnt > m) left = mid + 1;
            else right = mid;
        }
        return (int)left;


    }


    /**
     * 动态规划二维解法：
     * dp[i][j] 表示 [0, i - 1]的索引范围内 , 分成j段 的 最大值
     * 在中间切一刀，归于右侧的索引起点 = k， 索引终点 = i - 1,    k可以从0取到i - 1
     * 对于每一种k， dp[k][j - 1] 表示 0到k - 1部分被切成j - 1份的最大值，现在多了新的一段，这段的和 = nums[k] + ... + nums[i - 1]
     * 两者的较大者 就是 多切一刀后 的 最大值，  最后得到这么多最大值中的最小的值 赋值给 dp[i][j]
     *
     *
     * 注意： 比如dp[3][5] 表示 [0,2]索引范围内，切成5份， 不存在，所以dp的第一行 除了第一个都设为最大值
     * dp[i>0][0] 有东西，但是不切，也不是不对，所以第一列除了第一个 都设为最大值
     *
     *
     * @param nums
     * @param m: 能切几份
     * @return
     */
    public int splitArray(int[] nums, int m) {

        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];  //sub[i] = 0到i - 1对应值相加的和

        for (int i = 0; i <= n; ++i) for (int j = 0; j <= m ; ++j)
            dp[i][j] = Integer.MAX_VALUE;
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i)
            sub[i] = sub[i - 1] + nums[i - 1];



        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                for (int k = 0; k < i; ++k) {
                    int candidate = Math.max(dp[k][j - 1], sub[i] - sub[k]);   //sub[i] - sub[k]  = nums[k] + ... + nums[i - 1]
                    dp[i][j] = Math.min(dp[i][j], candidate);
                }
            }
        }

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[i].length; ++j) {
                System.out.print(dp[i][j] + " \t");
            }
            System.out.println();
        }


        return dp[n][m];

    }


    /**
     * 动态规划一维解法
     * @param nums
     * @param m
     * @return
     */
    public int splitArray2(int[] nums, int m) {

        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] sub = new long[n + 1];  //sub[i] = 0到i - 1对应值相加的和

        for (int i = 0; i <= n; ++i) for (int j = 0; j <= m ; ++j)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= n; ++i)
            sub[i] = sub[i - 1] + nums[i - 1];

        for (int j = 1; j <= m; ++j) {
            for (int i = n; i >= j; --i) {  //逆序
                for (int k = j - 1; k <= i - 1; ++k) {
                    long candidate = Math.max(dp[k], sub[i] - sub[k]);   //sub[i] - sub[k]  = nums[k] + ... + nums[i - 1]
                    dp[i] = Math.min(dp[i], candidate);
                }
            }
        }
        return (int)dp[n];
    }
}
