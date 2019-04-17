package com.stan.algorithm;

public class 正则表达式匹配 {
    public static void main(String[] args) {

    }
}
class Solution_10 {
    public boolean isMatch(String s, String p) {

        int s_len = s.length();
        int p_len = p.length();
        boolean[][] memory = new boolean[s_len+1][p_len+1];
        memory[0][0] = true;

        for (int i = 0; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {

            }
        }




        return false;
    }
}