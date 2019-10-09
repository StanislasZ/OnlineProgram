package com.stan.leetcode;

public class _5最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L + 1 - 2;
    }


//    public String longestPalindrome(String s) {
//
//        int N = s.length();
//        int max = 0;
//        String res = "";
//        for (int i = 0; i < N; ++i) {
//
//            int len1 = getPaliFromCenter(s, i, i);
//            int len2 = getPaliFromCenter(s, i, i + 1);
//            if (len1 * 2 - 1 > len2 * 2 && len1 * 2 - 1 > max) {
//                max = len1 * 2 - 1;
//                res = s.substring(i - len1, i + len1 + 1);
//
//            } else if (len2 * 2 > len1 * 2 -1 && len2 * 2 > max) {
//                max = len2 * 2;
//                res = s.substring(i - len2 + 1, i + 1 + len2);
//
//            }
//
//        }
//        return res;
//    }
//
//    private int getPaliFromCenter(String s, int i, int j) {
//
//        int len = 0;
//        while (i >= 0 && j < s.length()) {
//            if (s.charAt(i) != s.charAt(j)) break;
//            -- i;
//            ++ j;
//            ++ len;
//        }
//        return len;
//    }
}
