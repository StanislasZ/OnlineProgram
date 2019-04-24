package com.stan.leetcode;

public class _55跳跃游戏 {

}
class Solution_55 {
    public boolean canJump(int[] nums) {

        return canJump(nums, nums.length - 1);
    }

    //从后前向遍历
    public boolean canJump(int[] nums, int tail) {

        if (tail == 0) return true;  //递归终点

        int i = tail - 1;
        for (; i >= 0; i--) {
            if (tail - i <= nums[i]) {
                return canJump(nums, i);   //这个点能走到终点，就看能不能到这个点，进入递归
            }
        }
        return false;


    }

}