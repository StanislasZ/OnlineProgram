package com.stan.公司笔试.浦发银行;

import java.util.*;

public class 字典序全排列 {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        boolean[] vis = new boolean[arr.length];
        dfs(arr, vis);
    }

    static List<Integer> temp = new ArrayList<>();

    //一搜到底
    public static void dfs(int[] nums, boolean[] vis) {
        //递归终点
        if (temp.size() == nums.length) {
            for (int i = 0; i < temp.size(); ++i) {
                if (i != temp.size() - 1) {
                    System.out.print(temp.get(i) + " ");
                } else {
                    System.out.println(temp.get(i));
                }
            }
            return;
        }

        Set<Integer> set = new HashSet<>();   //为了去重
        for (int i = 0; i < nums.length; i++) {

            if (!vis[i] && !set.contains(nums[i])) {
                //若没被使用过
                temp.add(nums[i]);
                vis[i] = true;
                set.add(nums[i]);
                //进入下层
                dfs(nums, vis);
                //回溯
                temp.remove(temp.size() - 1);
                vis[i] = false;

            }

        }


    }
}
