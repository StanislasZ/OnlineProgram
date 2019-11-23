package com.stan.data_structure.LRU;

import java.util.Hashtable;

/**
 * leetcode 146 方法2
 *
 * 双向链表 + 哈希表
 *
 */
public class LRUCache2 {

    /**
     * 内部节点类，构建双向链表
     * 链表中，靠近head的是最新访问过的，靠近tail的是旧的访问的
     */
    class Node {
        int key;   //在删除old时，弹出Node对象，要有key属性才能去map删
        int value;
        Node prev;
        Node next;
    }

    private Node head;   //伪头
    private Node tail;   //伪尾
    private int size;
    private int capacity;

    private Hashtable<Integer, Node> cache = new Hashtable<>();

    /**
     * 参数为初始容量的构造器
     * @param capacity
     */
    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }


    /**
     * 把新节点加到最前面
     * @param node
     */
    private void addNode(Node node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * 从链表中删除指定Node
     * @param node
     */
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        //node = null;    //不能写，因为popTail里调用完这个方法还有用
    }

    /**
     * 把已存在节点搬到最前面
     * 先删，再加
     * @param node
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 弹出最以前访问的节点
     * @return
     */
    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    /**
     * 暴露get
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    /**
     * 暴露put
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        Node node = cache.get(key);

        if (node == null) {
            //内部map中没有这个键
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);

            if (++size > capacity) {
                Node old = popTail();
                cache.remove(old.key);
                -- size;
            }
        } else {
            //更新
            node.value = value;
            moveToHead(node);
        }
    }


}
