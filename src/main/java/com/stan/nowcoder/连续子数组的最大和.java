package com.stan.nowcoder;

public class 连续子数组的最大和 {

    public static void main(String[] args) {
        int[] a = new int[]{1,-2,3,10,-4,7,2,-5};

    }

        public int FindGreatestSumOfSubArray(int[] arr) {


            if (arr.length == 1) return arr[0];
            int res = arr[0];

            //dp[i] = 以i为结尾的连续子序列
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            for (int i = 1; i < dp.length; ++i) {
                if (dp[i - 1] > 0) dp[i] = dp[i - 1] + arr[i];
                else dp[i] = arr[i];
                res = Math.max(res, dp[i]);

            }
            return res;

        }
}
