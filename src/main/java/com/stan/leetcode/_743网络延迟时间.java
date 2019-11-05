package com.stan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _743网络延迟时间 {


    /*
        有 N 个网络节点，标记为 1 到 N。

        给定一个列表 times，表示信号经过有向边的传递时间。 
        times[i] = (u, v, w)，其中 
        u 是源节点，v 是目标节点，
        w 是一个信号从源节点传递到目标节点的时间。

        现在，我们向当前的节点 K 发送了一个信号。
        需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。

        注意:

        N 的范围在 [1, 100] 之间。
        K 的范围在 [1, N] 之间。
        times 的长度在 [1, 6000] 之间。
        所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。

     */

    public static void main(String[] args) {

    }

    /**
     * times[i][0]到times[i][1]需要times[i][2]的时间
     * @param times: time[i]是长度为3的数组
     *
     * @param N
     * @param K: 从K扩散
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {

        // 构建邻接矩阵, 有向
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++)
            graph[i][j] = -1;
        //注意下标
        for (int[] info : times)
            graph[info[0] - 1][info[1] - 1] = info[2];

        return dijkstra(graph, N, K - 1);

    }

    /**
     * 寻找连接的最小的点， 不存在返回 - 1
     * @param distance
     * @param vis
     * @return
     */
    private int findMinVertex(int[] distance, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < distance.length; ++i) {
            if (!vis[i] && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Dijkstra算法， 基于贪心
     * 首先把起点到所有点的距离存下来， 找到最短的
     * 然后松弛一次，再找到最短的
     * 松弛： 用刚找到的最短的作为中转站，去其他点，看看是不是比起点直接去更近
     * 如果更近就更新距离
     *
     * 没使用堆（优先队列）优化
     * 应该是每次找min_i时时间复杂度为O(n)，使用堆优化后为O(logn)
     * 有空改进
     *
     *
     * @param graph
     * @param N
     * @param from
     * @return
     */
    private int dijkstra(int[][] graph, int N, int from) {

        int[] distance = new int[N];  //不断刷新distance，也就是各个点到from需要的时间
        boolean[] vis = new boolean[N];
        int res = -1;
        //初始化distance
        for (int i = 0; i < N; ++i)
            distance[i] = graph[from][i] == -1? Integer.MAX_VALUE : graph[from][i];
        vis[from] = true;

        for (int i = 0; i < N - 1; ++i) {
            int min_i = findMinVertex(distance, vis);
            if (min_i == -1) return -1;    // 有无法抵达的点

            vis[min_i] = true;  //from到min_i的距离已经是最短的了
            res = Math.max(res, distance[min_i]);  //
            //更新distance
            for (int j = 0; j < N; ++j) {
                //看一下min_i直接相连的点，且没被用过的，且能曲线救国的，就修正distance
                if (graph[min_i][j] != -1
                        && !vis[j]
                        && distance[min_i] + graph[min_i][j] < distance[j]) {
                    distance[j] = distance[min_i] + graph[min_i][j];
                }
            }

        }
        return res;

    }
}
