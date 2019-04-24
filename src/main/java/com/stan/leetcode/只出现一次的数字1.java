package com.stan.leetcode;

public class 只出现一次的数字1 {
    public static void main(String[] args) {

    }
}
class Solution_136 {
    public int singleNumber(int[] nums) {

        /**
         * 0异或x = x
         * x异或x = 0
         * a^b^c^a^c^b^d = 0^0^0^d =d
         */

        int rlt = 0;
        for (int num : nums) {
            rlt = rlt ^ num;
        }
        return rlt;
    }
}