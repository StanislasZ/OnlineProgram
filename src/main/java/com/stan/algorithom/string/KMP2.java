package com.stan.algorithom.string;


import java.util.HashSet;
import java.util.Set;

/**
 * 参考leetcode一个人的解释
 * 原理是算法红书里的状态机，用dp表达
 *
 * dp[i][j]
 *      i代表第几个状态
 *      j代表遇到的字符(ascii码)
 *      dp[i][j] 为 第i个状态时，碰到j这个字符，要去哪个状态
 *
 *
 */
public class KMP2 {

    public static void main(String[] args) {

        KMP2 kmp = new KMP2("abbcabab");
        System.out.println(kmp.search("ABABABCA"));
    }

    private int[][] dp;
    private String pattern;

    private Set<Character> set = new HashSet<>();


    /**
     * 遍历j时， X时 pattern[0,j]这个子串最长公共前后缀的长度len， 即一旦下一个字符和模式串中不对应
     *
     * 就要回退，退到第len个状态
     *
     * @param pattern
     */
    public KMP2(String pattern) {

//        for (char c : pattern.toCharArray()) set.add(c);

        this.pattern = pattern;
        int M = pattern.length();

        dp = new int[M][256];
        dp[0][pattern.charAt(0)] = 1;  //状态0遇到pattern第0个字符 -> 状态1
//        System.out.println("dp[0][" + pattern.charAt(0) + "] = " + 1);

        int X = 0;
        //当前状态j从1开始
        for (int j = 1; j < M; ++ j) {
//            System.out.println("j = "+ j);
            for (int c = 0; c < 256; ++ c) {
                if (pattern.charAt(j) == c) {
                    dp[j][c] = j + 1;
//                    System.out.println("    dp["+j+"]["+(char)c+"] = "+dp[j][c]);
                } else {
                    dp[j][c] = dp[X][c];
//                    if (set.contains((char)c)) {
//                        System.out.println("    dp["+j+"]["+(char)c+"] = dp[X]["+(char)c+"] = dp["+X+"]["+(char)c+"] = " +dp[j][c]);
//                    }
                }
            }
            //更新状态，在下一个j之前准备好
            //dp[X][?]在这句之前已经准备好了

            //举个例子，下一次j = 7, 要知道pattern[0,6]的最长公共前后缀长度len，即状态号len
            //因为txt中间某一段txt[i - 5, i]和pattern[0, 6]一样
            //接下来就是看txt下一个索引txt[i+1]是不是 = pattern[7]
            //如果不同的话，要回退，把txt目前的后缀txt[?, i]重新变成pattern的前缀，也就是pattern[0,?]，这个问号就是len

            X = dp[X][pattern.charAt(j)];
//            System.out.println("    X = " + X);
        }





    }

    public int search(String txt) {

        int M = pattern.length();
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
