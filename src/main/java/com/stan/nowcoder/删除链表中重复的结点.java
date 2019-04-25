package com.stan.nowcoder;

public class 删除链表中重复的结点 {
    public static void main(String[] args) {

    }
}
class Solution_删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr= head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {  //左连接为pre
                //发现和后一个相同
                ListNode temp = curr.next;
                while (temp != null) {
                    if (temp.val != curr.val) break;
                    temp = temp.next;
                }
                curr = temp;
                pre.next = curr;

            } else {
                pre = pre.next;
                curr = curr.next;
            }

        }

        return dummy.next;
    }
}