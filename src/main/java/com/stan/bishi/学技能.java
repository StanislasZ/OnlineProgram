package com.stan.bishi;

import java.util.Scanner;

public class 学技能 {
    public static void main(String[] args) {

        double n, k, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextDouble();
        k = scanner.nextDouble();
        m = scanner.nextDouble();
        if (m >= n) System.out.println((long)k);
        else System.out.println((int)Math.ceil(n * k /m));
    }
}
