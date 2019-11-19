package com.stan.leetcode;

public class _125验证回文串 {


    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new _125验证回文串().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {


        int l = 0;
        int r = s.length() - 1;
        while (l < r) {

            while (l < r && !isLetterOrNum(s.charAt(l))) ++ l;
            while (l < r && !isLetterOrNum(s.charAt(r))) -- r;

            if (!isEqual(s.charAt(l), s.charAt(r))) {
                return false;
            }
            ++ l;
            -- r;
        }
        return true;
    }


    private boolean isEqual(char a, char b) {

        if (a <= '9' && b >= 'A' || b <= '9' && a >= 'A') return false;  //不写这句的话 数字0和字母P竟然正好差distace
        int distance = 'A'-'a';

        return a == b || a-b == distance || b-a == distance;

    }

    private boolean isLetterOrNum(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}
