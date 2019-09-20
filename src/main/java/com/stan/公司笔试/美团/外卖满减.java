package com.stan.公司笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

public class 外卖满减 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = dp.length - 1; j >= 0; --j) {
                if (dp[j] && j + nums[i] < dp.length) {
                    dp[j + nums[i]] = true;
                }
            }
        }

        for (int i = x; i <= sum; ++i) {
            if (dp[i]) {
                System.out.println(i);
                break;
            }
        }


    }
}
