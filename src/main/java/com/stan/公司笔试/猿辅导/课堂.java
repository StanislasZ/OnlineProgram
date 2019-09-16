package com.stan.公司笔试.猿辅导;

import java.util.Scanner;

public class 课堂 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] nums = new int[n + 1];   //多开一格
        for (int i = 0; i < n; ++i) nums[i] = scanner.nextInt();

        int res = 0, sum = 0, left = 0, right = 0;

        while (right < n + 1) {
            if (sum <= s) sum += nums[right++];
            else {
                res = Math.max(res, right - 2 - left + 1);
                sum -= nums[left++];
            }
        }
        System.out.println(res);
    }
}
