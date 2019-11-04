package com.stan.leetcode;

import java.util.*;
import java.awt.Point;


/*
    无向图
    邻接表数组
    bfs
 */

public class _815公交路线 {

    public static void main(String[] args) {

        //int[][] routes = new int[][]{{25,33},{3,5,13,22,23,29,37,45,49},{15,16,41,47},{5,11,17,23,33},{10,11,12,29,30,39,45},{2,5,23,24,33},{1,2,9,19,20,21,23,32,34,44},{7,18,23,24},{1,2,7,27,36,44},{7,14,33}};

        int[][] routes = new int[][]{{1,2,7},{3,6,7}};
        int S = 1;
        int T = 6;
        System.out.println(new _815公交路线().numBusesToDestination2(routes, S, T));

    }


    /**
     * 把所有含起点的节点，在一开始一起丢进队列，作为第1层
     * 这样的话，只要碰到终点，直接就可以返回了，之前的方法必须让每一个都找到终点，就算剪纸，也快不了多少
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination2(int[][] routes, int S, int T) {

        if (S == T) return 0;
        int N = routes.length;

        //routes每行排序
        for (int[] arr : routes) Arrays.sort(arr);

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

        List<Integer> terminal = new ArrayList<>(); //包含终点的公交线路，也是某行

        Queue<Integer> queue = new LinkedList<>();  //bfs队列
        boolean[] vis = new boolean[N];

        //遍历routes，填充terminal
        for (int i = 0; i < N; ++i) {
            if (binarySearch(routes[i], S)) {
                queue.add(i);
                vis[i] = true;
            }
            if (binarySearch(routes[i], T)) terminal.add(i);
        }
        System.out.println(terminal);

        int level = 1;  //层数，对应乘了几部公交
        int level_cnt = queue.size(); //本层数量
        int curr_cnt = 0;  //本层当前遍历到第几个

        System.out.println("level_cnt = " + level_cnt);

        while (!queue.isEmpty()) {
            System.out.println("level = " + level);
            int top = queue.poll();
            if (terminal.contains(top)) {
                System.out.println("top = " + top);
                System.out.println("bingo");
                return level;
            }

            //top的邻接节点 入队列
            for (int i : neighbor[top]) {
                if (!vis[i]) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
            if (++ curr_cnt == level_cnt) {
                curr_cnt = 0;
                ++ level;
                level_cnt = queue.size();
            }
        }
        return -1;

    }


    /**
     * 针对每一个含起点的节点，各自bfs， 然后找到最小值， 垃圾
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

        int res = Integer.MAX_VALUE; //最终要返回的结果


        for (int start_i : start) {
            //从每个可能的起点出发
            int curr_min = Integer.MAX_VALUE;   //当次的值
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
