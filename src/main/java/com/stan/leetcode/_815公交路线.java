package com.stan.leetcode;

import java.util.*;
import java.awt.Point;

public class _815公交路线 {

    public static void main(String[] args) {

        int[][] routes = new int[][]{{25,33},{3,5,13,22,23,29,37,45,49},{15,16,41,47},{5,11,17,23,33},{10,11,12,29,30,39,45},{2,5,23,24,33},{1,2,9,19,20,21,23,32,34,44},{7,18,23,24},{1,2,7,27,36,44},{7,14,33}};
        int S = 7;
        int T = 47;
        System.out.println(new _815公交路线().numBusesToDestination(routes, S, T));

    }

    /**
     * TBD
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int N = routes.length;

        //routes每行排序
        for (int[] arr : routes) Arrays.sort(arr);

        List<Integer> start = new ArrayList<>();  //包含起点的公交线路，即routes的某行
        List<Integer> terminal = new ArrayList<>(); //包含终点的公交线路，也是某行

        //遍历routes，填充start, terminal
        for (int i = 0; i < N; ++i) {
            if (binarySearch(routes[i], S)) start.add(i);
            if (binarySearch(routes[i], T)) terminal.add(i);
        }
        System.out.println(start);
        System.out.println(terminal);

        //建立邻接表数组
        List<Integer>[] neighbor = new List[N];
        for (int i = 0; i < N; ++i) neighbor[i] = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (hasCommonStation(routes[i], routes[j])) {
                    neighbor[i].add(j);
                    neighbor[j].add(i);
                }
            }
        }

        int res = Integer.MAX_VALUE;


        for (int start_i : start) {
            //从每个可能的起点出发
            int curr_min = Integer.MAX_VALUE;
            int level = 1;
            int level_cnt = 1;
            int curr_cnt = 0;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] vis = new boolean[N];
            queue.add(start_i);
            vis[start_i] = true;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                if (terminal.contains(top)) {
                    curr_min = Math.min(curr_min, level);
                    break;
                }
                //top的邻接节点 入队列
                for (int i : neighbor[top]) {
                    if (!vis[i]) {
                        queue.add(i);
                        vis[i] = true;
                    }
                }
                if (++curr_cnt == level_cnt) {
                    ++ level;
                    level_cnt = queue.size();
                    curr_cnt = 0;
                }
            }
            res = Math.min(res, curr_min);
        }

        return res == Integer.MAX_VALUE? -1 : res;

    }




    /**
     * 线路A和线路B 是否有公共站点
     * A， B都已排序
     * @param A
     * @param B
     * @return
     */
    public boolean hasCommonStation(int[] A, int[] B) {

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            else if (A[i] < B[j]) ++ i;
            else ++ j;
        }
        return false;
    }

    /**
     * arr中是否有数字target
     * arr已排序
     * @param arr
     * @param target
     * @return
     */
    private boolean binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

}
