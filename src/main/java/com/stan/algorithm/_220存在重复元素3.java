package com.stan.algorithm;

import java.util.TreeSet;

public class _220存在重复元素3 {

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
     * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
     * 并且 i 和 j 之间的差的绝对值最大为 k。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     */
}

class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        /**
         * 滑窗加TreeSet
         */

        TreeSet<Long> set = new TreeSet<>(); //存nums[i]

        for (int i = 0; i < nums.length; i++) {
            //找到 比 nums[i] - t的最小元素
            Long ceiling = set.ceiling((long)nums[i] - (long)t);
            //保证 |target - nums[i]| <= t
            if (ceiling != null && ceiling - (long)nums[i] <= (long)t) return true;

            //没找到
            set.add((long)nums[i]);
            if (set.size() == k + 1) set.remove((long)nums[i - k]);

        }
        return false;
    }
}
