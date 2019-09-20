package com.stan.公司笔试.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

public class 谁当裁判 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] round = new int[N];
        for (int i = 0; i < N; i++) round[i] = scanner.nextInt();

        if (N == 2) {
            System.out.println(round[0] + round[1]);
            return;
        }

        int cnt = 0;

        Arrays.sort(round);
        if (round[0] == 0) {
            System.out.println(round[N - 1]);
            return;
        }
        int min_i = 0;  //值大于0的最小索引
        for (; min_i < N; ++min_i) {
            if (round[min_i] > 0) break;
        }

        cnt = round[min_i + 1];
        cnt = cnt + Math.max(round[min_i], round[N - 1] - round[min_i + 1]);
        System.out.println(cnt);

    }
}
