package com.stan.leetcode;

public class _300最长上升子序列 {
    public static void main(String[] args) {


    }
}
class Solution_300 {
    public int lengthOfLIS(int[] nums) {


        if (nums.length <= 1) return nums.length;

        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int i = 1;
        for (int j = 1; j < lis.length; j++) {
            if (nums[j] > lis[i - 1]) lis[i++] = nums[j];  //比lis最右边那个还大，就直接拷过去
            else {

                int insert_index = binarySearch(lis, 0, i - 1, nums[j]);  //找到插入位置
                lis[insert_index] = nums[j];    //保证lis升序的同时，未雨绸缪
            }
        }
        return i;
    }


    //二分查找，同样的值，会插在前面
    public int binarySearch(int[] nums, int head, int tail, int target) {

        while (head <= tail) {
            int mid = (head + tail) / 2;

            if (nums[mid] < target) head = mid + 1;
            else tail = mid - 1;

        }
        return head;
    }
}