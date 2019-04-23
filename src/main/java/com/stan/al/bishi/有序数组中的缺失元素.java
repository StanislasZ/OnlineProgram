package com.stan.al.bishi;

public class 有序数组中的缺失元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4};
        System.out.println(new Solution_有序数组中的缺失元素_().missingElement(arr, 3));
    }
}
class Solution_有序数组中的缺失元素_ {
    public int missingElement(int[] nums, int k) {

        int i = 0;
        while (i+1 < nums.length && nums[i + 1] - nums[i] - 1 < k) {

            k = k - (nums[i + 1] - nums[i] - 1);
            i++;

        }
        return nums[i] + k;
    }
}