package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _118杨辉三角 {
    /**
     * 给定一个非负整数 n，生成杨辉三角的前 n 行。
     */
}
class Solution_118杨辉三角 {

    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();







    /**
     * 暴力法，两层循环
     * @param n
     * @return
     */
    public List<List<Integer>> generate(int n) {
        if (n == 0) return rlt;
        temp.add(1);
        rlt.add(new ArrayList<>(temp));

        for (int i = 1; i <= n - 1; ++i) {
            temp.clear();
            int len = i + 1;
            temp.add(1);
            for (int j = 1; j <= len - 2; ++j) {
                List<Integer> prev_list = rlt.get(i - 1);
                temp.add(prev_list.get(j - 1) + prev_list.get(j));
            }
            temp.add(1);
            rlt.add(new ArrayList<>(temp));
        }

        return rlt;


    }
}