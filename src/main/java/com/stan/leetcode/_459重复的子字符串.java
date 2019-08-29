package com.stan.leetcode;


import static com.stan.algorithom.string.KMP.KMP;

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
        //KMP具体见 algorithom.string.KMP
        return s.length() > 1 && KMP(dual, s) != -1;
    }



}
