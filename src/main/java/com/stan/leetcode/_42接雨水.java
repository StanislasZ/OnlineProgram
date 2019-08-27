package com.stan.leetcode;

public class _42接雨水 {

    public int trap(int[] height) {
        int N = height.length;
        int[] left = new int[N]; //每列左侧的最大值
        int[] right = new int[N];//每列右侧的最大值

        for (int i = 1; i < N; ++i) left[i] = Math.max(left[i - 1], height[i - 1]);
        for (int i = N - 2; i >= 0; --i) right[i] = Math.max(right[i + 1], height[i + 1]);

        int water = 0;
        for (int i = 0; i < N; ++i) {
            int level = Math.min(left[i], right[i]);  //每一列雨水能有多高，由左侧最高和右测最高的较小者决定
            water += Math.max(0, level - height[i]);
        }
        return water;

    }
}
