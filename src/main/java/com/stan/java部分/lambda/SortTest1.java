package com.stan.java部分.lambda;

import java.util.*;

public class SortTest1 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(2, 2);
        map.put(1, 3);


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Comparator.comparingInt(x -> -x.getValue()));

        System.out.println(list);


    }
}
