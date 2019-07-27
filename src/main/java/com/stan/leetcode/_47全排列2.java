package com.stan.leetcode;

import java.util.*;

public class _47全排列2 {
    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        //先排序
        Arrays.sort(nums);


        boolean[] vis = new boolean[nums.length];

        dfs(nums, vis);
        return rlt;

    }
    //一搜到底
    public void dfs(int[] nums, boolean[] vis) {
        //递归终点
        if (temp.size() == nums.length) {
            rlt.add(new ArrayList<Integer>(temp));
            return;
        }

        Set<Integer> set = new HashSet<>();   //为了去重
        for (int i = 0; i < nums.length; i++) {



            if (!vis[i] && !set.contains(nums[i])) {
                //若没被使用过
                temp.add(nums[i]);
                vis[i] = true;
                set.add(nums[i]);
                //进入下层
                dfs(nums, vis);
                //回溯
                temp.remove(temp.size() - 1);
                vis[i] = false;

            }

        }


    }

}
