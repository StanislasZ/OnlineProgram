package com.stan.公司笔试.网易;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 二进制1个数相同 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        while (T-- > 0) {
            res = 0;
            int N = scanner.nextInt();
            int[] arr= new int[N];
            for (int i = 0; i <N; ++i) {
                arr[i] = scanner.nextInt();
                int cnt = NumberOf1(arr[i]);
                if (! set.contains(cnt)) {
                    ++ res;
                    set.add(cnt);
                }
            }
            System.out.println(res);
        }


    }
    public static int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;

    }
}
