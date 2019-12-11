package com.stan.公司笔试.cisco;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 变种KMP
 */
public class SpecialKMP {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String x = scanner.nextLine();

        System.out.println(firstOccurrence(s, x));



    }


    public static int firstOccurrence(String s, String x) {
        String pattern = x;
        int M = pattern.length();
        Set<Character> set = new HashSet<>();
        int[][] dp = new int[M][256];
        dp[0][pattern.charAt(0)] = 1;  //状态0遇到pattern第0个字符 -> 状态1

        int X = 0;
        //当前状态j从1开始
        for (int j = 1; j < M; ++ j) {
            for (int c = 0; c < 256; ++ c) {

                //在这里多加一个或
                if (pattern.charAt(j) == c || pattern.charAt(j) == '*') {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[X][c];
                }
            }

            X = dp[X][pattern.charAt(j)];

        }

        //search
        String txt = s;
        int N = txt.length();

        //一开始状态为0
        int j = 0;
        for (int i = 0; i < N; ++i) {
            //当前状态是j， 遇到了字符txt[i]
            j = dp[j][txt.charAt(i)];
            if (j == M) return i - M + 1;
        }
        //没到达终止态，匹配失败
        return -1;
    }



}
