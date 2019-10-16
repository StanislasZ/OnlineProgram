package com.stan.公司笔试.微众银行;

import java.util.Scanner;

public class 移动排序 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        int[] res = new int[nums.length];
        int len = lengthOfLIS(nums, res);
        int part1 = 0;
        for (int i = 0; i < len; ++i) {
            part1 += res[i];
        }
        System.out.println(Math.min(part1, sum - part1));
    }

    public static int lengthOfLIS(int[] nums, int[] lis) {

        if (nums.length <= 1) return nums.length;
        lis[0] = nums[0];
        int i = 1;
        for (int j = 1; j < lis.length; j++) {
            if (nums[j] >= lis[i - 1]) lis[i++] = nums[j];  //比lis最右边那个还大，就直接拷过去
            else {
                int insert_index = binarySearch(lis, 0, i - 1, nums[j]);  //找到插入位置
                lis[insert_index] = nums[j];    //保证lis升序的同时，未雨绸缪
            }
        }
        return i;
    }

    //二分查找，同样的值，会插在前面
    public static int binarySearch(int[] nums, int head, int tail, int target) {
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] < target) head = mid + 1;
            else tail = mid - 1;
        }
        return head;
    }
}
