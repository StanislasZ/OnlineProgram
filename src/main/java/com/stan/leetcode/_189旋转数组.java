package com.stan.leetcode;

public class _189旋转数组 {

    /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate(int[] nums, int k) {


        int N = nums.length;
        k = k % N;

        reverse(nums, 0, N - 1);    //整体翻转
        reverse(nums, 0, k - 1);    //前k个翻转
        reverse(nums, k, N - 1);    //后N-k个翻转



    }

    private void reverse(int[] nums, int head, int tail) {
        while (head < tail) {
            int temp = nums[head];
            nums[head++] = nums[tail];
            nums[tail--] = temp;
        }
    }

    /**
     * 双重循环
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     */
    public void rotate_1(int[] nums, int k) {
        int N = nums.length;
        k = k % N;

        while (k > 0) {


            int last = nums[N - 1];  //备份
            //挪步法
            for (int i = N - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
            k--;

        }
    }
}
