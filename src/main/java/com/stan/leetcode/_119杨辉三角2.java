package com.stan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _119杨辉三角2 {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     */
}
class Solution_119杨辉三角2 {
    public List<Integer> getRow(int rowIndex) {


        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2; i < dp.length; i++){
            for(int j = i - 1; j > 0; j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;




//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//
//        while (rowIndex > 0) {
//            List<Integer> temp = new ArrayList<>();
//            int len = list1.size() + 1;
//            temp.add(1);
//            for (int i = 1; i <= len - 2; ++i) {
//                temp.add(list1.get(i - 1) + list1.get(i));
//            }
//            temp.add(1);
//            list1 = new ArrayList<>(temp);
//            rowIndex--;
//        }
//        return list1;

    }
}