package com.stan.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baidu11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        System.out.println(new Solution9999().getCnt(target));


    }
}
class Solution9999{
    Set<String> set = new HashSet<>();

    public int getCnt(String target) {

        if (target == null || target.length() == 0) return 0;
        int N = target.length();
        if (N == 1) return 1;
        for (int i = 0; i < N; i++) {
            String temp = target.substring(1) + target.charAt(0);
            if (!set.contains(temp)) {
                set.add(temp);
            }
            target = temp;
        }

        //abca  bcaa caab aabc abca

        return set.size();

    }
}
