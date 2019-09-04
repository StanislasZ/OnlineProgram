package com.stan.公司笔试.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 任务调度 {

    static int res = 0;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }

    static int schedule(int m,int[] array) {

        int N = array.length;
        if (N <= m) {
            int max = 0;
            for (int i = 0; i < N; ++i) max = Math.max(max, array[i]);
            return max;
        }


        int max = 0;
        dfs(array, m,0, 0);
        return res;
    }

    /**
     *
     * @param arr
     * @param level： 当前第几段
     *
     */
    static void dfs(int[] arr, int m, int level, int curr) {

        //递归终点
        if (level < m && curr >= arr.length) return;
        if (level == m) {
            if (curr != arr.length) return;
            int temp = 0;
            for (int ele: list) temp = Math.max(temp, ele);
            res = res > 0? Math.min(res, temp) : temp;
            return;
        }


        for (int end = curr; end <= arr.length - (m - level); ++end) {

            //计算本段和
            int sum = getSum(arr, curr, end);
            if (res > 0 && sum > res) return;


            list.add(sum);
            dfs(arr, m, level + 1, end + 1);
            list.remove(list.size() - 1);  //回溯
        }


    }

    static int getSum(int[] arr, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; ++i) sum += arr[i];
        return sum;
    }
}
