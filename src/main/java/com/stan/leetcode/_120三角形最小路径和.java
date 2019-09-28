package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _120三角形最小路径和 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{2}));
        list.add(Arrays.asList(new Integer[]{3,4}));
        list.add(Arrays.asList(new Integer[]{6,5,7}));
        list.add(Arrays.asList(new Integer[]{4,1,8,3}));


        System.out.println(new _120三角形最小路径和().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> tri) {
        int rows = tri.size();
        //dp[i][j] 表示 从它开始向下的最小路径和
        int[][] dp = new int[rows][];

        for (int i = tri.size() - 1; i >= 0; --i) {
            dp[i] = new int[tri.get(i).size()];
            for (int j = 0; j < tri.get(i).size(); ++j) {
                if (i == tri.size() - 1) dp[i][j] = tri.get(i).get(j);
                else dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + tri.get(i).get(j);
            }
        }
        return dp[0][0];




    }

}
