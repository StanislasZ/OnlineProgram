package com.stan.公司笔试.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 任务调度 {

    /*
        m个节点，有一批任务要执行，每个任务需要时间为 array[i]
        每个节点在同一时间只能执行一个任务，每个节点只能执行连续的任务
        请问任务完成的最短时间。

        输入：
        3 5
        1 5 3 4 2

        输出：
        6
        解释：
        1+ 5  ；  3 ；   4  + 2
     */

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
        //如果本段是最后一段，直接加到最后
        //这段end最大值与 m 有关
        for (int end = level == m - 1? arr.length - 1 : curr; end <= arr.length - (m - level); ++end) {

            //计算本段和
            int sum = getSum(arr, curr, end);
            if (res > 0 && sum > res) return; //剪纸
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
