package com.stan.leetcode;

public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int [] arr , int k) {

        //时间复杂度：log(n) + log(n) = log(n)
        return binarySearch_last(arr, k) - binarySearch_first(arr, k);
    }

    //返回这个数第一次出现的位置
    private int binarySearch_first(int[] arr,int target) {

        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int mid = (head + tail) >> 1;
            if (arr[mid] < target) head = mid + 1;
            else tail = mid - 1;
        }
        return head;
    }
    //返回这个数最后一次出现的位置
    private int binarySearch_last(int[] arr,int target) {

        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int mid = (head + tail) >> 1;
            if (arr[mid] > target) tail = mid - 1;
            else head = mid + 1;
        }
        return head;
    }

}
