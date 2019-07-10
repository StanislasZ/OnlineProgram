package com.stan.nowcoder;

public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }
}
class Solution_数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {

        int N = array.length;
        int left = 0;
        int right = N - 1;
        int mid = N >> 1;
        //找出第 N/2 大的元素
        int p = partition(array, left, right);
        while (p != mid) {
            if (p > mid) right = p - 1;
            else         left  = p + 1;

            p = partition(array, left, right);
        }
        int rlt = array[p];
        return check(array, rlt)? rlt : 0;

    }

    public boolean check(int[] arr, int target) {
        int cnt = 0;
        for (int ele : arr) {
            if (ele == target) cnt++;
        }
        return cnt * 2 > arr.length;
    }


    public int partition(int[] arr, int head, int tail) {

        int sep = arr[tail];
        int left = head;
        for (int i = head; i < tail; i++) {
            if (arr[i] < sep) {
                swap(arr, left++, i);
            }
        }
        swap(arr, left, tail);
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}