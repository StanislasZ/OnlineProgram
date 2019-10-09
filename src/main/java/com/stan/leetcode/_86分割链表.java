package com.stan.leetcode;

public class _86分割链表 {

    /**
     * 维护2个链表时， 用new ListNode()的方式增加节点，不用考虑引用的问题
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode small_dummy = new ListNode(0);
        ListNode big_dummy = new ListNode(0);
        ListNode small = small_dummy;
        ListNode big = big_dummy;

        while (head != null) {
            if (head.val < x) {
                small_dummy.next = new ListNode(head.val);
                small_dummy = small_dummy.next;
            } else {
                big_dummy.next = new ListNode(head.val);
                big_dummy = big_dummy.next;
            }
            head = head.next;
        }
        small_dummy.next = big.next;
        return small.next;
    }

    /**
     *  维护两个链表时，指向原链表的节点，一定要消除big链表的最后一个节点的next,置为null
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {

        ListNode small_dummy = new ListNode(0);
        ListNode big_dummy = new ListNode(0);
        ListNode small = small_dummy;
        ListNode big = big_dummy;

        while (head != null) {
            if (head.val < x) {
                small_dummy.next = head;   //指向原链表中的节点
                small_dummy = small_dummy.next;
            } else {
                big_dummy.next = head;    //指向原链表中的节点
                big_dummy = big_dummy.next;
            }
            head = head.next;
        }
        big_dummy.next = null;   // 这里必须置为null ！！！！
        small_dummy.next = big.next;
        return small.next;
    }

}
