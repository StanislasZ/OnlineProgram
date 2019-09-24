package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56合并区间 {
    public static void main(String[] args) {

    }

    /**
     * 按区间的左值排序
     * 比较 当前区间的右值 和 下一个区间的左值
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right)
                right = Math.max(right, intervals[++i][1]);
            res.add(new int[]{left, right});
            ++ i;
        }
        return res.toArray(new int[0][]);
    }
}
