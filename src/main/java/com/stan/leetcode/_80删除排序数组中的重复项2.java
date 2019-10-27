package com.stan.leetcode;

public class _80删除排序数组中的重复项2 {

    public static void main(String[] args) {


    }

    public int removeDuplicates(int[] nums) {

        int cnt = 1;
        int unique = 0;  //维护一个索引，使[0, unique]的元素重复不超过2次

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[unique]) {
                if (cnt == 2) continue;  //已经出现2次，看下一个
                else ++ cnt;
            } else {
                cnt = 1;   //不一样，置1
            }
            //日常丢前面去
            nums[++unique] = nums[i];
        }
        return unique + 1;
    }

}
