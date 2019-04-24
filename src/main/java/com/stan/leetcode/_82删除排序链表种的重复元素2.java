package com.stan.leetcode;

public class _82删除排序链表种的重复元素2 {
}
class Solution_82 {

    //换个思路，看这个和下一个是不是一样，而不是这个和前一个是不是一个
    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, p1 = head, p2 = null;
        while (p1 != null) {
            if (p1.next != null && p1.val == p1.next.val) {
                p2 = p1.next;
                while (p2 != null && p2.val == p1.val) p2 = p2.next;
                prev.next = p2;   //prev指向开始不一样的第一个
                p1 = p2;
            }else {
                prev = prev.next;
                p1 = p1.next;
            }
        }
        return dummy.next;
    }


    //垃圾思路，看这个和前一个是不是一样，那么就要存这个，这个的前一个，前一个的前一个，共3个
    //垃圾
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prepre = dummy;
        ListNode pre    = head;
        ListNode curr   = head.next;

        while (curr != null) {

            if (curr.val == pre.val) {  //当前的值 和 前一个的值 相同
                //一搜到底
                int temp = curr.val;
                ListNode l_temp = curr;
                while (l_temp != null) {
                    if (l_temp.val != temp) break;
                    l_temp = l_temp.next;
                }
                prepre.next = l_temp;  //让prepre指向l_temp

                if (l_temp == null) return dummy.next;   //一群一样后面屁也没了，直接返回
                else {
                    //prepre不变
                    pre = l_temp;
                    curr = l_temp.next;
                }
            }else {
                prepre = prepre.next;
                pre    = pre.next;
                curr   = curr.next;
            }
        }
        return dummy.next;

    }
}