package com.stan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78子集 {

    public static void main(String[] args) {


    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, nums.length, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int curr, int N, List<Integer> temp) {
        //递归终点
        if (curr == N) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //加当前
        temp.add(nums[curr]);
        dfs(nums, curr + 1, N, temp);
        //回溯
        temp.remove(temp.size() - 1);
        //不加当前
        dfs(nums, curr + 1, N, temp);

    }
}
