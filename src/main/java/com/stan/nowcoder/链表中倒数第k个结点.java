package com.stan.nowcoder;

public class 链表中倒数第k个结点 {
}
class Solution_链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null) return null;
        ListNode h1 = head;
        ListNode h2 = head;

        //让h1先走k - 1步
        int cnt = k - 1;
        while (cnt > 0) {
            h1 = h1.next;
            if (h1 == null) return null;
            cnt--;
        }
        while (h1.next != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h2;


    }
}