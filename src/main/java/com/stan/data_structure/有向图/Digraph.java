package com.stan.data_structure.有向图;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//有向图
public class Digraph {

    private final int V;   //顶点数
    private int E;   //边数edges
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0; v < V; ++v) adj[v] = new LinkedList<>();
    }

    public Digraph(Scanner scanner) {

        this(scanner.nextInt());
//        E = scanner.nextInt();
        scanner.nextInt();
        System.out.println("E = " + E);
        while (scanner.hasNextLine()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            //System.out.println("v = " + v + ", w =" +w);
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

    //返回该图的反向图
    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; ++v) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }


    @Override
    public String toString() {
        String s = V + " vertices, " + E + "directed edges\n";
        for (int v = 0; v < V; ++v) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

}
