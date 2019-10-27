package com.stan.leetcode;

import java.util.Stack;

public class _84柱状图中最大的矩形 {

    public static void main(String[] args) {
//        int[] arr = new int[]{2,1,5,6,2,3};
        int[] arr = new int[]{1,1};
        System.out.println(new _84柱状图中最大的矩形().largestRectangleArea_stack(arr));
    }


    /**
     * 栈
     * 仍需理解
     * @param heights
     * @return
     */
    public int largestRectangleArea_stack(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;

        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int curr = stack.pop();
                //宽度就是(现在栈顶值, i) ，两边都是开， 高度= heights[curr]
                maxarea = Math.max(maxarea, heights[curr] * (i - 1 - (stack.peek()+1) + 1));
            }
            stack.push(i);
        }


        while (stack.peek() != -1) {
            int curr = stack.pop();
            maxarea = Math.max(maxarea, heights[curr] * (heights.length - 1 - (stack.peek()+1) + 1));
            }
        return maxarea;
    }

    /**
     * 分治
     * 时间复杂度： 最好O(nlogn)  最差O(n方)，也就是数组也排好序的
     *
     * 优化：我们可以用线段树代替遍历来找到区间最小值。单词查询复杂度就变成了O(logn),总体就是O(nlogn)
     *  不懂！
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_fenzhi(int[] heights) {
        return process(heights, 0, heights.length - 1);
    }

    private int process(int[] height, int left, int right) {

        if (left > right) return 0;
        int low = findMin(height, left, right);
        //三者取最大者
        return Math.max(height[low] * (right - left + 1), Math.max(process(height, left, low - 1),process(height, low + 1, right)));
    }

    //返回区间内最小数的索引
    private int findMin(int[] height, int left, int right) {
        int res = left;
        for (int i = left + 1; i <= right; ++i) {
            if (height[i] < height[res]) res = i;
        }
        return res;
    }



    /**
     * 优化的暴力
     * 时间复杂度： O(n方)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int N = heights.length;

        int res = 0;

        for (int i = 0; i < N; ++i) {
            int low = heights[i];
            for (int j = i; j < N; ++j) {
                low = Math.min(low, heights[j]);
                res = Math.max(res, (j - i + 1) * low);
            }
        }
        return res;
    }



}
