package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46全排列 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        new _46全排列().permute(a);
    }

    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] vis;


    public List<List<Integer>> permute2(int[] nums) {

        if (nums.length == 0) return rlt;
        vis = new boolean[nums.length];

        dfs(nums, 0);
        return rlt;
    }

    private void dfs(int[] nums, int cnt) {
        //递归终点
        if (cnt == nums.length) {
            rlt.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                temp.add(nums[i]);
                vis[i] = true;
                dfs(nums, ++cnt);
                //回溯
                cnt--;
                temp.remove(temp.size() - 1);
                vis[i] = false;
            }
        }
    }

    //*****************************************
    //交换法
    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) return rlt;
        permutation(nums, 0);
        return rlt;
    }

    /**
     * 交换法 1 2 3 4
     * 比如第0位可以是 1 2 3 4的一个，通过交换使第0位变化
     * 递归时，j从i开始，保证了0到i-1的数不动，保证了不同。
     * @param nums
     * @param i
     */
    private void permutation(int[] nums, int i) {
        //递归终点
        if (i == nums.length) {
            temp.clear();
            for (int ele : nums) temp.add(ele);
            System.out.println(temp);
            rlt.add(new ArrayList<>(temp));
        }
        for (int j = i; j < nums.length; j++) {
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
