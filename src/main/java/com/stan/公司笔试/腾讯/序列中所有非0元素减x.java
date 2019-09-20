package com.stan.公司笔试.腾讯;

import java.util.*;


public class 序列中所有非0元素减x {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) set.add(scanner.nextInt());

        Iterator iterator = set.iterator();
        int pre = 0;
        while (iterator.hasNext()) {
            int temp = (int)iterator.next();
            System.out.println(temp - pre);
            pre = temp;
        }
    }

}
