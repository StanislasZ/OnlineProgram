package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15三数之和 {


    public static void main(String[] args) {
        int[] a= new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new _15三数之和().threeSum(a));
    }



    List<List<Integer>> rlt=new ArrayList<>();
    List<Integer> temp = new ArrayList<>();


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length <= 2) return rlt;
        Arrays.sort(nums);

        dfs(nums, 0, 0, 0);
        return rlt;


    }

    private void dfs(int[] nums, int cnt, int curr, int sum) {
        //递归终点
        if (cnt == 3) {
            if (sum == 0) rlt.add(new ArrayList<>(temp));
            return;
        }

        for (int i = curr; i < nums.length; ++i) {
            if (i > curr && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            dfs(nums, cnt + 1, i + 1, sum + nums[i]);
            temp.remove(temp.size() - 1);
        }

    }
}
