package com.stan.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {


        //见leetcode239 这里注释较少



    }
}
class Solution_滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int [] nums, int k) {

        LinkedList<Integer> deque = new LinkedList<>();

        ArrayList<Integer> rlt = new ArrayList<>();
        if (k == 0 || k > nums.length) return rlt;

        //先操作第一个滑窗
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        rlt.add(nums[deque.peekFirst()]);

        //开始遍历
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            //开始检查队头是否仍在滑窗内
            while (deque.peekFirst() < (i - k + 1)) {
                deque.pollFirst();
            }
            rlt.add(nums[deque.peekFirst()]);
        }
        return rlt;




    }
}