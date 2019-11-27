package com.stan.leetcode;

import java.util.*;

public class _133克隆图 {

    Map<Integer,Graph_Node> map = new HashMap<>(); //存储new过的新结点
    Queue<Graph_Node> queue = new LinkedList<>();  //队列，存储原图中没处理好的结点的引用
    Graph_Node head; //克隆图的引用


    /**
     * 把没有克隆过都加到队列里
     *
     * 每次拿到队列头，是老的节点，去拿到老节点的邻居
     *
     * 同时
     *
     * @param node
     * @return
     */
    public Graph_Node cloneGraph(Graph_Node node) {

        if(node == null) return null;
        queue.add(node);

        while(!queue.isEmpty()){

            Graph_Node t = queue.poll(); //弹出未处理节点
            Graph_Node bro;  //t的克隆节点

            if (!map.containsKey(t.val)) {
                bro = new Graph_Node(t.val,new ArrayList<>());
                map.put(t.val, bro);
            } else {
                bro = map.get(t.val); //有的话就直接拿
            }

            if (map.size() == 1) head = bro; //最后return head

            List<Graph_Node> t_list = t.neighbors; //原来节点的邻居

            //根据老节点的老邻居 都搞到 新节点的新邻居
            for (Graph_Node n : t_list){

                if (!map.containsKey(n.val)) {
                    queue.add(n);
                    Graph_Node newNode = new Graph_Node(n.val, new ArrayList<>());
                    bro.neighbors.add(newNode);
                    map.put(n.val,newNode);

                } else {
                    bro.neighbors.add(map.get(n.val));
                }
            }
        }
        return head;
    }



}

class Graph_Node {
    public int val;
    public List<Graph_Node> neighbors;

    public Graph_Node() {}

    public Graph_Node(int _val,List<Graph_Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}