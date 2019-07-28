package com.stan.leetcode;

import java.util.*;

public class _47全排列2 {
    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();


    public List<List<Integer>> permuteUnique2(int[] nums) {
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

    //*****************************************
    //交换法
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0) return rlt;
        permutation(nums, 0);
        return rlt;
    }

    private void permutation(int[] nums, int i) {
        //递归终点
        if (i == nums.length) {
            temp.clear();
            for (int ele : nums) temp.add(ele);
            rlt.add(new ArrayList<>(temp));
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            //避重
            if (set.contains(nums[j])) continue;
            set.add(nums[j]);
            swap(nums, i, j);
            //因为j从i开始，所以递归进去后，之后改变后面的，前面（索引0到i-1）不动。
            permutation(nums, i + 1);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
