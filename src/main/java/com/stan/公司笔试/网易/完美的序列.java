package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 完美的序列 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        while (T-- > 0) {
//            int n = scanner.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; ++i) nums[i] = scanner.nextInt();
//
//            int[] dp = new int[n];  //dp[i] 为 0到i的最长子序列的长度, 且必须取到第i个数
//            int[] sum = new int[n];  //dp[i]对应的和为 sum[i]
//
//            dp[0] = 1;
//            sum[0] = nums[0];
//            for (int i = 0; i < n; ++i) {
//                dp[i] = 1;
//                sum[i] = nums[i];
//                for (int j = 0; j < i; ++j) {
//
//                    if (nums[i] > sum[j]) {
//                        if (dp[j] + 1 > dp[i]) {
//                            dp[i] = dp[j] + 1;
//                            sum[i] = sum[j] + nums[i];
//                        } else if (dp[j + 1] == dp[i]) {
//                            sum[i] = Math.min(sum[i], sum[j] + nums[i]);
//                        }
//                    }
//                }
//                //System.out.println("dp[" + i + "] = "  + dp[i] + ", sum[" + i + "] = " +sum[i]);
//            }
//
//            int res = 0;
//            for (int i = 0; i < n; ++i) res = Math.max(res, dp[i]);
//            System.out.println(res);
//        }


        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0){
            int geshu = in.nextInt();
            int[] shuzu = new int[geshu];
            for (int i = 0; i < geshu; i++) {
                shuzu[i] = in.nextInt();
            }

//            System.out.println(shuzu);
            int t = panbie(shuzu);
            System.out.println(t);
        }


    }

    private static int panbie(int[] res){

        int[] dp = new int[res.length];
        dp[0] = res[0];
//        dp[1] = res[1];
        if (res.length == 1){
            return 1;
        }
        int temp = 0;

        for (int i = 1; i < res.length; i++) {
            if (res[i]>=dp[i-1]){
                dp[i] = dp[i-1] + res[i];
            }else {
                temp = i - temp;
                dp[i] = res[i];
            }
            temp = Math.max(temp, i-temp+1);
        }

        return temp;



    }
}
