package com.stan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _210课程表2 {


    /*
        思路：
        判断是否有环
        若有，不存在
        若无，找到拓扑排序
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //入度数组 indegrees[i]表示编号为i的顶点的入度
        int[] indegrees = new int[numCourses];
        //邻接表数组, adj[2]为标号为2的顶点 指向的顶点的 list
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<Integer>();

        for (int[] edge : prerequisites) {
            ++ indegrees[edge[0]];   //更新入度表
            adj[edge[1]].add(edge[0]);  //更新邻接表数组
        }

        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegrees[i] == 0) queue.add(i);   //入度为0 的 入队列
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            -- numCourses;
            for (int w : adj[top]) { //遍历标号为top的指向的所有顶点的list,把它们的入度都-1
                if (-- indegrees[w] == 0) queue.add(w);
            }
            order[index++] = top;  //加入到拓扑排序数组中
        }
        if (numCourses == 0) return order;
        else return new int[0];
    }
}
