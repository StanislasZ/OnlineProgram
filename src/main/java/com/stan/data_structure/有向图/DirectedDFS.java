package com.stan.data_structure.有向图;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DirectedDFS {

    private boolean[] marked;


    //在G中 找到 从s可达的所有顶点
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];  //长度是边数
        dfs(G, s);
    }

    //在G中找到 从sources中的所有顶点 可达的 所有顶点
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) dfs(G, s);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    //v是否可达
    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/com/stan/data_structure/有向图/tinyDG.txt"));

        Digraph G = new Digraph(scanner);
        scanner.close();
        System.out.println(G);


        Integer[] temp = new Integer[]{6,7,8};




        DirectedDFS reachable = new DirectedDFS(G, Arrays.asList(temp));

        System.out.println("这些点可达的点有");
        for (int v = 0; v < G.V(); ++v) {
            if (reachable.marked[v]) System.out.print(v + " ");
        }
        System.out.println();

    }
}
