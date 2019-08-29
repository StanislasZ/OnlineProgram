package com.stan.leetcode;

public class _459重复的子字符串 {

    /*
        给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

        示例 1:

        输入: "abab"

        输出: True

        解释: 可由子字符串 "ab" 重复两次构成。
        示例 2:

        输入: "aba"

        输出: False
        示例 3:

        输入: "abcabcabcabc"

        输出: True

        解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)


     */

    /**
     * 简单题
     * 调用indexOf 击败55%
     * 相联系的考点：用KMP实现indexOf
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        return s.length() > 1 && (s + s).indexOf(s, 1) != s.length();
    }


    /**
     * 用KMP代替indexOf 击败70%
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {


        int N = s.length();
        String dual = (s + s).substring(1, 2 * N - 1);
        return s.length() > 1 && KMP(dual, s) != -1;
    }


    public void getNext(String pattern, int[] next) {
        next[0] = -1;
        int i = 0, len = -1;
        //循环内有next[++i]，防止数组越界，i < len - 1
        while (i < pattern.length() - 1) {

            if (len == -1 || pattern.charAt(i) == pattern.charAt(len)) {
                next[++i] = ++len;
            } else {
                len = next[len];
            }
        }
        // System.out.println("**");
        // for (int ele : next) System.out.println(ele);
        // System.out.println("**");
    }

    public int KMP(String text, String pattern) {
        int i = 0, j = 0;
        int[] next = new int[pattern.length()];
        getNext(pattern, next);

        int len1 = text.length();
        int len2 = pattern.length();
        while (i < len1) {
            if (j == len2 - 1 && text.charAt(i) == pattern.charAt(j)) {
                return i - j;   //匹配到，直接退出
            }
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];   //j回退
            }
        }
        return -1;
    }
}
