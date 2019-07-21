package com.stan.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47全排列 {
    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums, 0);
        return rlt;
    }

    public void dfs(int[] nums, int cnt) {

        if (cnt == nums.length) {
            //递归终点
            rlt.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!vis[i]) {
                vis[i] = true;
                temp.add(nums[i]);

                dfs(nums, ++cnt);

                //回溯
                vis[i] = false;
                temp.remove(temp.size() - 1);
                cnt--;
            }
        }


    }

}
