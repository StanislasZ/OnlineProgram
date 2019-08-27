package com.stan.leetcode;

import java.util.*;

public class _40组合总数2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }
    private void dfs(int[] candidates,int target, int start){
        if (target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        //比如start = 0 ，可以以0-len的任意一个开始，加上对应的值，再进入递归
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            //避免 1123 出现 1(第一个)23 和 1(第二个)23 重复
            if (i != start && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates,target - candidates[i],i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] a= new int[]{4,4,2,1,4,2,2,1,3};
        System.out.println(new _40组合总数2().combinationSum2(a, 6));
    }
}
