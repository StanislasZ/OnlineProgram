package com.stan.leetcode;

public class _19删除链表的倒数第N个节点 {

    /**
     * 先找到倒数第 n+1 个节点
     * 该节点.next =  该节点.next.next 即可
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 1; i <= n + 1; ++i) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow是倒数第 n + 1 个节点
        slow.next = slow.next.next;
        return dummy.next;

    }
}
