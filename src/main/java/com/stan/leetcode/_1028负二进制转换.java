package com.stan.leetcode;

public class _1028负二进制转换 {
    public static void main(String[] args) {

    }
}
class Solution_1028 {
    public String baseNeg2(int N) {  // N > 0

        if (N == 0) return "0";
        int[] arr = null;
        String rlt = "";

        while (N != 0) {
            int base = 1;
            int cnt = 0;
            while (base * 2 <= N) {     //求2^n <= N 的最大n ， base = 2^n
                base = base * 2;
                cnt++;
            }
            N = N - base;
            if (cnt % 2 == 0) {
                if (arr == null) {
                    arr = new int[cnt + 3];
                }
                arr[cnt]++;  //偶数位，加1
                ensure(arr);
            }else {
                if (arr == null) {
                    arr = new int[cnt + 3];

                }
                arr[cnt]--;  //奇数位，减1
                ensure(arr);
            }
        }
        int i = arr.length-1;
        for (; i>=0 ;i--) {
            if (arr[i] != 0) break;
        }
        for (; i>=0 ;i--) {
            rlt = rlt + arr[i];
        }
        return rlt;
    }
    public void ensure(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 2) {   //2个这个位置就是1个大一号位置， 这个如果是加的，让大一号少减  这个如果是减的，让大一号的少加
                arr[i] = 0;
                arr[i + 1]--;
            }else if (arr[i] == -1) {
                arr[i] = 1;
                arr[i + 1]++;
            }

        }

    }


}
