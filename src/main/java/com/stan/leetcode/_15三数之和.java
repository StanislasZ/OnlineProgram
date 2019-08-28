package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15三数之和 {


    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
//        System.out.println(new _15三数之和().threeSum(a));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;  //i<L<R i大于0后面也大于0  不能加起来=0
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    R--;
                    L++;
                } else if (sum < 0) L++;
                else                R--;
            }
        }
        return res;

    }


    //*********************************************************************

    List<List<Integer>> rlt = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();


    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

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
