package com.stan.公司笔试.ByteDance;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class 找厕所 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        //System.out.println(s);
        char[] arr = s.toCharArray();

        int[] res = new int[N];

        int left = s.indexOf('O');
        int right = s.lastIndexOf('O');
        //System.out.println(left);
        //System.out.println(right);

        //右刷一遍
        for (int i = left; i < N; ++i) {
            if (arr[i] == 'O') res[i] = 0;
            else res[i] = res[i - 1] + 1;
        }

        //左刷一遍
        for (int i = right; i >= 0; --i) {
            if (arr[i] == 'O') res[i] = 0;
            else res[i] = res[i] > 0 ? Math.min(res[i + 1] + 1, res[i]) : res[i + 1] + 1;
        }

        for (int i = 0; i < N; ++i) {
            if (i == N - 1) System.out.println(res[i]);
            else System.out.print(res[i] + " ");
        }
    }
}
