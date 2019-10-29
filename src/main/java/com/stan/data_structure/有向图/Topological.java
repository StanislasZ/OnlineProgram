package com.stan.data_structure.有向图;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//leetcode 207 课程表


//拓扑排序
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph G) {

        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            System.out.println("无环");
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/com/stan/data_structure/有向图/tinyDG.txt"));

        Digraph G = new Digraph(scanner);
        scanner.close();
        System.out.println(G);

        Topological top = new Topological(G);
        for (int v :top.order) System.out.println(v);

    }
}
