package com.stan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _116填充每个节点的下一个右侧节点指针 {

    /**
     * 大神解法
     *
     * 反思： 没有注意到题目的特殊性，完全二叉树，才能用这个方法做
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {

        if (root == null) return null;
        Node pre = root;   //每一层的入口节点
        Node curr = null;  //每一层遍历时的节点

        while (pre.left != null) {
            curr = pre;
            while (curr != null) {
                curr.left.next = curr.right;   //把下一层水平方向的连好
                if (curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;  //右移
            }
            pre = pre.left;  //修改成下一层的入口
        }
        return root;
    }


    /**
     * 层次遍历， 不理想
     * @param root
     * @return
     */
    public Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level_cnt = 1;
        int curr = 0;

        Node pre = null;
        while (!queue.isEmpty()) {

            Node top = queue.poll();

            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);

            //处理next
            if (pre != null) pre.next = top;
            pre = top;

            if (++ curr == level_cnt) {
                pre = null;
                level_cnt = queue.size();
                curr = 0;
            }

        }

        return root;

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
