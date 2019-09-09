package com.stan.公司笔试.爱奇艺;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 排列计数 {

    /*
        leetcode 903

        给定一个长度为N - 1 且只包含0和1 的序列A1到 AN-1
        如果N个排列，满足 Ai =  0, Pi < P i + 1
                          Ai =  1, Pi > Pi  + 1
        则符合要求
        那么有多少种符合要求的排列

     */


    static int res = 0;
    static boolean[] use;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N - 1];
        use = new boolean[N];
        for (int i = 0; i < arr.length; ++i) arr[i] = scanner.nextInt();
        dfs(arr, N, 0, -1);
        System.out.println(res);

    }

    /**
     *
     * @param arr
     * @param N
     * @param curr: 当前索引
     * @param pre： 上一位索引的值
     */
    public static void dfs(int[] arr, int N, int curr, int pre) {

        //递归终点
        if (curr == N) {
            ++ res;
            res = res % 1000000007;
            //System.out.println(list);
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (use[i - 1]) continue;
            if (curr > 0) {
                if (arr[curr - 1] == 1 && i > pre) continue;
                else if (arr[curr - 1] ==0 && i < pre) continue;
            }
            //到这里， i可以用
            use[i - 1] = true;
//            list.add(i);
            dfs(arr, N, curr + 1, i);
            use[i - 1] = false;  //回溯
//            list.remove(list.size() - 1);

        }

    }
}
