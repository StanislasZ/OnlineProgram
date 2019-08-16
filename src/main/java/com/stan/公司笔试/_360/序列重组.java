package com.stan.公司笔试._360;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 序列重组 {

    /*
        通过36%
        贪心不对
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int jinzhi = scanner.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < len; ++i) a[i] = scanner.nextInt();
        for (int i = 0; i < len; ++i) b[i] = scanner.nextInt();

        boolean[] use_a = new boolean[len];
        boolean[] use_b = new boolean[len];
        List<Integer> list = new ArrayList<>();
        int cnt = len;
        while (cnt-- > 0) {
            int max = -1;
            int i1 = -1;
            int i2 = -1;
            for (int i = 0; i < len; ++i) {
                if (use_a[i]) continue;
                for (int j = 0; j < len; j++) {
                    if (use_b[j]) continue;
                    int temp = (a[i] + b[j]) % jinzhi;
                    if (temp > max) {
                        max = temp;
                        i1 = i;
                        i2 = j;
                    }
                }
            }
            use_a[i1] = true;
            use_b[i2] = true;
            list.add(max);
        }
        for (int i = 0; i < list.size(); ++i) {
            if (i < list.size() - 1) System.out.print(list.get(i) + " ");
            else System.out.println(list.get(i));
        }
    }
}
