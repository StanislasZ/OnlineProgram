package com.stan.公司笔试;

import java.util.HashMap;
import java.util.Map;

public class 易混淆数 {
    public static void main(String[] args) {
        System.out.println(new Solution_混淆().confusingNumber(11));
    }
}

class Solution_混淆 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();




    public boolean confusingNumber(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int new_num = 0;
        int temp = N;
        while (N != 0) {
            int curr = N % 10;
            System.out.println();
            if (!map.containsKey(curr)) return false;

            new_num = new_num * 10 + map.get(curr);




            N = N / 10;
        }
        System.out.println("***");
        System.out.println("new_num = " +new_num);
        System.out.println("N = " + N);
        System.out.println("***");
        System.out.println(new_num == N);
        return temp != new_num;




    }
}