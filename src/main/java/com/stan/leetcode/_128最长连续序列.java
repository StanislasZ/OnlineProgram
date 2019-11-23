package com.stan.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _128最长连续序列 {


    /**
     * 先把所有数存到set里
     *
     * 然后开始遍历set元素x
     *
     * 如果 set有x - 1 那 从x算起 比 x - 1算起 少1 ，直接跳过
     *
     * 所以当set没有 x -1时，开始，  如果有x + 1,计数器加1 ，如果有 x + 2 计数器再加1
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int num : set) {

            if (!set.contains(num - 1)) {
                //如果contains 从 num开始算 肯定 < num - 1开始算，直接跳过就行
                int curr = num;
                int cnt = 1;
                while (set.contains(curr + 1)) {
                    ++ curr;
                    ++ cnt;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }





    /**
     * 暴力
     * @param nums
     * @return
     */
    public int longestConsecutive_bf(int[] nums) {

        int max_span = 0;

        for (int num : nums) {
            int curr = num;
            int span = 1;

            while (arrayContains(nums, curr + 1)) {
                curr += 1;
                span += 1;
            }
            max_span = Math.max(max_span, span);
        }
        return max_span;
    }

    /**
     * if arr[?] == num
     * @param arr
     * @param num
     * @return
     */
    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }


}
