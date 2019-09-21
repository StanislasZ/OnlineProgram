package com.stan.公司笔试.网易;

import java.util.Scanner;

public class 翻倍 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();


            int cnt = 0;

            while (B - A > p) {
                p = p * q;
                ++ cnt;
            }
            ++ cnt;
            System.out.println(cnt);

        }
    }
}
