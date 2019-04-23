package com.stan.al.bishi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长重复子串 {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(new Solution_最长重复子串().longestRepeatingSubstring(str));
    }
}
class Solution_最长重复子串 {
    public int longestRepeatingSubstring(String S) {


        if (S.length() <= 1) return 0;
        int len = S.length();
        int max_len = 0;
        int max =0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len ; j++) {

                String curr = S.substring(i, j + 1);
                if (map.containsKey(curr)) {
                    map.put(curr, map.get(curr) + 1);


                } else {
                    map.put(curr, 1);
                }


            }
        }
        for (String key : map.keySet()) {
            System.out.println("key = " +key +" , value = " + map.get(key));

            if (key.length() > max_len) {
                if (map.get(key) >= 2) {
                    max = map.get(key);
                    max_len = key.length();
                }
            }

        }
        return max_len;







//        int max = 0;
//        Map<String, Integer> map = new HashMap<>();
//
//        int left = 0;
//        int right = 0;
//        while (left < len && right < len){
//
//        }
//
//        return -1;
    }
}