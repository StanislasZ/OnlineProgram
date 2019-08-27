package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> rlt = new ArrayList<>();

        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        find(rlt, temp, candidates, target, 0);
        return rlt;

    }
    public void find(List<List<Integer>> rlt, List<Integer> temp, int[] candidates, int target, int num) {
        //递归的终点
        if(target == 0){
            rlt.add(temp);
            return;
        }
        if (target < candidates[0]) return;

        for (int i = num; i< candidates.length && candidates[i] <= target; i++) {
            //deep copy
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(rlt, list, candidates, target - candidates[i], i);
        }


    }
}
