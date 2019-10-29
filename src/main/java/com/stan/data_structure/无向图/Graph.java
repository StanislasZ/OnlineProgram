package com.stan.data_structure.无向图;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//无向图
public class Graph {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/com/stan/data_structure/无向图/G.txt"));
        Graph G = new Graph(scanner);
        scanner.close();
        System.out.println(G);
    }

    private final int V;
    private int E;

    private List<Integer>[] adj;  //邻接表, 数组的元素的链表的头

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0; v < V; ++v) adj[v] = new LinkedList<>();
    }

    public Graph(Scanner scanner) {

        this(scanner.nextInt());
        E = scanner.nextInt();
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

    //向图中增加一条边 v-w， （加在前面）
    void addEdge(int v, int w) {
        adj[v].add(0,w);
        adj[w].add(0,v);
        ++ E;
    }

    //返回和相邻的所有顶点的迭代对象
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    //计算无向图G中的顶点v的度数
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) ++ degree;
        return degree;
    }

    //计算所有顶点的最大度数
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); ++v) {
            if (degree(G, v) > max) max = degree(G, v);
        }
        return max;
    }

    //计算所有顶点的平均度数
    public static double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    //计算自环个数
    public static int numberOfSelfLoops(Graph G) {
        int cnt = 0;
        for (int v = 0; v < G.V(); ++v) {
            for (int w : G.adj(v)) {
                if (v == w) ++ cnt;
            }
        }
        return cnt / 2;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
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

