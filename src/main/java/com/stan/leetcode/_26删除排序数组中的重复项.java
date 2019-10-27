package com.stan.leetcode;

public class _26删除排序数组中的重复项 {

    public int removeDuplicates(int[] nums) {


        int unique = 0;   //维护一个索引，使0-unique的元素都unique

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[unique]) continue;
            else nums[++unique] = nums[i];
        }
        return unique + 1;
    }
}
