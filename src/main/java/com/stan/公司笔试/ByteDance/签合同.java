package com.stan.公司笔试.ByteDance;

import java.util.*;

public class 签合同 {


    static Map<Integer, Set<Integer>> post_map = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = -1;

        int T = 5;
       // while (scanner.hasNextLine()) {
        while (T-- > 0) {

            String s = scanner.nextLine();
            String[] s_arr = s.split(" ");
            int[] arr = new int[s_arr.length];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(s_arr[i]);
                if (!post_map.containsKey(arr[i])) post_map.put(arr[i], new HashSet<>());
            }

            for (int i = 1; i < arr.length; ++i) post_map.get(arr[i]).add(arr[0]);


        }

        System.out.println(post_map);





    }

    public static void update(int target, int curr) {

    }
}
