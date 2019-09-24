package com.stan.leetcode;

public class _75颜色分类 {

    /**
     * 0丢到前面，2丢到后面，1跳过，参考三路快排
     * @param nums
     */
    public void sortColors(int[] nums) {



        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 1) {
                ++ i;
                continue;
            } else if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else {
                swap(nums, i, right--);
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
