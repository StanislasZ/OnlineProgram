package com.stan.data_structure.有向图;


import java.util.Stack;

//有向环
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;  //为了最后找到环的时候，能列举出环中的所有顶点，需要知道 谁指向了谁
    private Stack<Integer> cycle;  //有向环上的所有顶点
    private boolean[] onStack;  //递归调用的栈上的所有顶点， 如某顶点某时刻在递归调用中，为true


    public DirectedCycle(Digraph G) {

        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) dfs(G, v);
        }
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

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
