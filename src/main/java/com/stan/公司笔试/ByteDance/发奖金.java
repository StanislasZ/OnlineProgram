package com.stan.公司笔试.ByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 发奖金 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(100);
            return;
        }

        int[] table = new int[N];
        for (int i = 0; i < N; ++i) {
            table[i] = scanner.nextInt();
        }
        int[] bonus = new int[N];
        List<Integer> list = new ArrayList<>();



    }
}
