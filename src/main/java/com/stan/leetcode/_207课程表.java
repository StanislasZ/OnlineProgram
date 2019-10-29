package com.stan.leetcode;

import java.util.*;

public class _207课程表 {


    /**
     * 关注某时刻所有点的入度，删除入度为0的点，并把从他们指向的点的入度-1
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish_indegree(int numCourses, int[][] prerequisites) {

        //入度数组 indegrees[i]表示编号为i的顶点的入度
        int[] indegrees = new int[numCourses];
        //邻接表数组, adj[2]为标号为2的顶点 指向的顶点的 list
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<Integer>();

        for (int[] edge : prerequisites) {
            ++ indegrees[edge[0]];   //更新入度表
            adj[edge[1]].add(edge[0]);  //更新邻接表数组
        }

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
        }
        return numCourses == 0;
    }




    //*************************************************************

    private boolean[] marked;
    private int[] edgeTo;  //为了最后找到环的时候，能列举出环中的所有顶点，需要知道 谁指向了谁
    private Stack<Integer> cycle;  //有向环上的所有顶点
    private boolean[] onStack;  //递归调用的栈上的所有顶点， 如某顶点某时刻在递归调用中，为true


    /**
     * 判断是否有向图是否有环即可
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;

        //构建有向图
        Digraph G = new Digraph(n, prerequisites);

        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v);
        }

        return !hasCycle();
    }

    //深度遍历，过程中判断是否有环
    private void dfs(Digraph G, int v) {

        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;  //若存在环，一定是被改回false前就有某个顶点指向了自己
    }

    //是否有环
    public boolean hasCycle() {
        return cycle != null;
    }
}

//有向图类
class Digraph {

    private final int V;   //顶点数
    private int E;   //边数edges
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0; v < V; ++v) adj[v] = new LinkedList<>();
    }

    public Digraph(int n, int[][] condition) {

        this(n);
        for (int i = 0; i < condition.length; ++i) {
            int v = condition[i][1];
            int w = condition[i][0];
            addEdge(v, w);
        }
    }

    //返回图的顶点数
    int V() {
        return V;
    }

    //返回图的边数
    int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(0, w);   //边是有向的 v -> w
        ++ E;
    }

    //由顶点v指出的边 连接的所有顶点 ，  这些顶点的数量就是v的出度
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


}
