package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 逆序对距离之和 {

    private static int cnt = 0;
    private static int[] aux;  //辅助数组

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = scanner.nextInt();

        System.out.println(InversePairs(nums));
    }

    public static int InversePairs(int [] arr) {
        aux = new int[arr.length];
        split(arr, 0, arr.length - 1);
        return cnt;
    }

    private static void split(int[] arr, int head, int tail) {
        if (head < tail) {
            int mid = (head + tail) >> 1;
            split(arr, head, mid);
            split(arr, mid + 1, tail);
            mergeAndCount(arr, head, mid, tail);
        }
    }

    private static void mergeAndCount(int[] arr, int head, int mid, int tail) {
        for (int i = head; i <= tail; ++i) {
            aux[i] = arr[i];
        }
        int p1 = mid;  //左边数组的最后一个
        int p2 = tail; //右边数组的最后一个
        int p3 = tail; //整段的最后一个

        while (p1 >= head || p2 >= mid + 1) {
            if (p1 == head - 1) arr[p3--] = aux[p2--];   //左边加完了
            else if (p2 == mid) arr[p3--] = aux[p1--];   //右边加完了
            else if (aux[p1] > aux[p2]) {  //左边大
                for (int i = mid + 1; i <= p2; ++i) {
                    cnt = cnt - aux[i] + aux[p1];
                }
                arr[p3--] = aux[p1--];
            } else {
                //右边大,正序
                arr[p3--] = aux[p2--];
            }

        }
        while (p1 >= head) arr[p3--] = aux[p1--];
        while (p2 >= (mid + 1)) arr[p3--] = aux[p2--];
    }
}
