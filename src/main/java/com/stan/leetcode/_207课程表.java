package com.stan.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class _207课程表 {


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

        Digraph G = new Digraph(n, prerequisites);

        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v);
        }

        return !hasCycle();
    }

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


    public boolean hasCycle() {
        return cycle != null;
    }
}


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
