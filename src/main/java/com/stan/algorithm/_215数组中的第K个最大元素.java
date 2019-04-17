package com.stan.algorithm;

public class _215数组中的第K个最大元素 {
    public static void main(String[] args) {

        int[] arr = {3,2,1,5,6,4};

        int k = 2;
        System.out.println(new Solution_215().findKthLargest(arr,k));

    }
}
class Solution_215 {
    public int findKthLargest(int[] nums, int k) {

        if (k > nums.length) return -1;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k );

    }

    public int findKthLargest(int[] nums, int head, int tail, int k) {
        int p = partition(nums, head, tail);

        if (p == k)     return nums[k];
        else if (p < k) return findKthLargest(nums, p + 1, tail, k);
        else            return findKthLargest(nums, head, p - 1, k);
    }
    //切分
    public int partition(int[] nums, int head, int tail) {

        int sep = nums[tail];
        int i = head;
        for (int j = head; j <= tail - 1; j++) {
            if (nums[j] <= sep) exch(nums, i++, j);
        }
        exch(nums, i, tail);
        return i;

    }
    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}