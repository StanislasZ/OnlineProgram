package com.stan.公司笔试.华为;

import java.util.Arrays;
import java.util.Scanner;

public class _2048 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; ++i) nums[i] = in.nextInt();
            int target = 1024;
            int need = 2;
            int cnt = 1;
            for (int i = 9; i >= 0; --i) {
                if (nums[i] == need) {
                    System.out.println(cnt);
                    break;
                } else {
                    //不够
                    cnt = cnt + (need - nums[i]);
                    target = target / 2;
                    need = (need - nums[i]) * 2;
                }
            }
        }
    }
}
