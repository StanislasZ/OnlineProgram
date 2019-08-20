package com.stan.algorithom.递归;

public class 反转字符串 {

    public static void main(String[] args) {

        String str = "abcde";
        System.out.println(new 反转字符串().reverse(str));

    }

    public String reverse(String str) {

        return str.length() <= 1? str : reverse(str.substring(1)) + str.charAt(0);
    }
}
