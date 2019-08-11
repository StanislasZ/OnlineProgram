package com.stan.leetcode;

public class _416分割等和子集 {


    /*
        给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

        注意:

        每个数组中的元素不会超过 100
        数组的大小不会超过 200
        示例 1:

        输入: [1, 5, 11, 5]

        输出: true

        解释: 数组可以分割成 [1, 5, 5] 和 [11].
         

        示例 2:

        输入: [1, 2, 3, 5]

        输出: false

        解释: 数组不能分割成两个元素和相等的子集.

     */


    /**
     * 一维
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {

        int sum = 0;
        for (int ele : nums) sum += ele;
        if ((sum & 1) == 1 || nums.length == 1) return false;

        sum = sum >> 1;
        int N = nums.length;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i < N; ++i) {
            //从右向左遍历，保证
            for (int j = sum; j >= 0; --j) {
                dp[j] = dp[j] || (nums[i] <= j && dp[j - nums[i]]);
            }
        }
        return dp[sum];

    }


    /**
     * 二维
     * dp[i][j] : 从0到i选取元素相加，和是否可以等于j
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int ele : nums) sum += ele;
        if ((sum & 1) == 1 || nums.length == 1) return false;

        sum = sum >> 1;
        int N = nums.length;

        boolean[][] dp = new boolean[N][sum + 1];

        dp[0][0] = true;
        dp[0][nums[0]] = true;  //初始化

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j <= sum; ++j) {
                dp[i][j] = dp[i - 1][j]? true : nums[i] <= j? dp[i - 1][j - nums[i]] : false;
            }
        }
        return dp[N - 1][sum];


    }



    private boolean find = false;
    public boolean canPartition_dfs(int[] nums) {

        int sum = 0;
        for (int ele : nums) sum += ele;
        if ((sum & 1) == 1 || nums.length == 1) return false;

        sum = sum >> 1;
        int N = nums.length;

        dfs(nums, 0, 0, sum);
        return find;

    }

    public void dfs(int[] nums, int i, int cnt, int sum) {
        System.out.println("i = " + i + ", cnt = "+cnt + ", len = " + nums.length);

        if (find || i >= nums.length) return;
        //递归终点
        if (cnt == sum) {
            find = true;
            return;
        }

        dfs(nums, i + 1, cnt, sum);
        dfs(nums, i + 1, cnt + nums[i], sum);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100};
        //int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(new _416分割等和子集().canPartition_dfs(nums));
    }
}
