package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _131分隔回文串 {



    public static void main(String[] args) {

    }


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        dfs(s, -1, new ArrayList<>());
        return res;
    }

    /**
     * dfs
     *
     * @param s
     * @param last_i：上一段回文的最后一个索引
     * @param last_part： 0到last_i对应的list
     */
    private void dfs(String s, int last_i, List<String> last_part) {

        //递归终点
        if (last_i == s.length() - 1) {
            res.add(new ArrayList<>(last_part));
            return;
        }
        for (int j = last_i + 1; j < s.length(); ++j) {
            if (isHui(s, last_i + 1, j)) {
                List temp = new ArrayList(last_part);
                temp.add(s.substring(last_i+1, j + 1));
                dfs(s, j, temp);
            }
        }
    }

    private boolean isHui(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
