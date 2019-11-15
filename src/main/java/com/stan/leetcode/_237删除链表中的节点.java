package com.stan.leetcode;

public class _237删除链表中的节点 {


    /**
     * 绝世傻逼题
     * @param node
     */
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
