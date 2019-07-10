package com.stan.nowcoder;

import java.util.ArrayList;

public class 最小的K个数 {


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        /**
         * 思路： partition
         */

        ArrayList<Integer> rlt = new ArrayList<>();
        int N = input.length;
        //特殊情况
        if (k <= 0 || k > N) return rlt;
        int left = 0;
        int right = N - 1;
        int p = partition(input, left, right);
        while (p != k - 1) {
            if (p > k - 1) right = p - 1;
            else           left  = p + 1;
            p = partition(input, left, right);
        }
        for (int i = 0; i < k; i++)
            rlt.add(input[i]);
        return rlt;

    }

    public int partition(int[] arr, int head, int tail) {
        int sep = arr[tail];
        int left = head;
        for (int i = head; i < tail; i++) {
            if (arr[i] < sep) swap(arr, left++, i);
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
