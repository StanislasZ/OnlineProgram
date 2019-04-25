package com.stan.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _239滑动窗口的最大值 {
    /**
     * 给定一个数组 nums，
     * 有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口 k 内的数字。
     * 滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) return new int[0];
        //双头队列，队头存放的是索引小的，队尾放的是索引大的
        //队头存最大值的索引
        Deque<Integer> deque = new LinkedList<>();

        int[] rlt = new int[nums.length - k + 1];
        int rlt_i = 0; //结果数组中的索引

        //先操作第一个滑窗
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();   //清除比当前值小的尾部(索引也小于当前索引)
            }
            deque.addLast(i);   //加在尾部
        }
        //到这里，队头是前k中最大的，
        //索引比这个索引小 && 值也小的，直接滚
        //索引比这个索引大 ，值小的，  需要放在队尾， 因为这些小的元素靠右，万一大的不在滑窗内了，这些有用

        rlt[rlt_i] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();   //清除比当前值小的尾部(索引也小于当前索引)
            }
            deque.addLast(i);   //加在尾部

            //检查队头索引 是否符合  滑窗要求  [i-k+1,i] 即 要>= (i-k+1)
            while (deque.peekFirst() < (i - k + 1)) {
                deque.pollFirst();
            }
            rlt[++rlt_i] = nums[deque.peekFirst()];
        }
        return rlt;

    }
}