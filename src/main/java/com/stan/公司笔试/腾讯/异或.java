package com.stan.公司笔试.腾讯;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 异或 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; ++i) a[i] = scanner.nextInt();
        for (int i = 0; i < n; ++i) b[i] = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = a[i] + b[j];
                if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if ((entry.getValue() & 1) == 0) continue;
            res = res ^ entry.getKey();
        }
        System.out.println(res);

    }
}
