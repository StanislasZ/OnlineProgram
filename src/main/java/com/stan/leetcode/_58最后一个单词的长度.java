package com.stan.leetcode;

public class _58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {

        s = s.trim();
        if (s.length() == 0) return 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != ' ') --i;
        return s.length() - i - 1;
    }
}
