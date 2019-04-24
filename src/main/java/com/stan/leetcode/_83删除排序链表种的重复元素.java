package com.stan.leetcode;

public class _83删除排序链表种的重复元素 {
}
class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        ListNode pre = head;

        while (curr != null) {
            if (pre.val == curr.val) pre.next = curr.next;  //删除当前结点,pre指向curr的下一个,pre不变
            else                     pre = pre.next;   //pre右移
            curr = curr.next;   //2种情况都要让curr右移
        }
        return head;
    }
}