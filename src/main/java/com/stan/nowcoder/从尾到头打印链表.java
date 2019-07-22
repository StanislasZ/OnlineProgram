package com.stan.nowcoder;

import java.util.ArrayList;

public class 从尾到头打印链表 {

    ArrayList<Integer> rlt = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode != null) dfs(listNode);
        return rlt;

    }
    public void dfs(ListNode head) {
        //递归终点
        if (head == null) return;
        dfs(head.next);
        rlt.add(head.val);

    }
}
