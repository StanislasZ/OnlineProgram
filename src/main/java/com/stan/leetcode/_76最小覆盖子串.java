package com.stan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _76最小覆盖子串 {

    public String minWindow(String s, String t) {

        //特殊输入
        if (t.isEmpty() || t.length() > s.length()) return "";
        String ans = "";
        int cnt = 0, left = 0, right = 0, minLen = s.length() + 1;
        Map<Character, Integer> map = new HashMap<>();

//        for (int i = 0; i < )
        // todo

        return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
       // new _76最小覆盖子串().minWindow(s, t);
    }
}
