package com.stan.leetcode;

public class _152乘积最大子序列 {

    public static void main(String[] args) {
        System.out.println(new _152乘积最大子序列().maxProduct(new int[]{-4, -3, -2}));
    }


    /**
     * 遍历一次数组，
     * 遍历某次时，维护0-i时的最大值， 最小值 ，迭代， 3种情况
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int curr_max = 1, curr_min = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int temp = curr_max;
            curr_max = Math.max(nums[i], Math.max(curr_max * nums[i], curr_min * nums[i]));
            curr_min = Math.min(nums[i], Math.min(temp * nums[i], curr_min * nums[i]));
            res = Math.max(res, curr_max);
        }
        return res;
    }
}
