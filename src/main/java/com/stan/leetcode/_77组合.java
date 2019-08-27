package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77组合 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {


        dfs(n, 0, k, 1);
        return res;

    }

    private void dfs(int n, int cnt, int k, int curr){

        //递归终点
        if (cnt == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //已有cnt个，共k个，还要弄k - cnt 个
        //从n， n- 1.... 第 k -cnt个 为  n + 1 - (k - cnt) ，即上界
        for (int i = curr; i <= (n + 1 - (k -cnt)); ++i) {
            temp.add(i);
            dfs(n, cnt + 1, k, i + 1);
            temp.remove(temp.size() - 1);
        }


    }
}
