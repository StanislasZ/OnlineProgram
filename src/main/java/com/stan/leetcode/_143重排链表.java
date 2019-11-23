package com.stan.leetcode;

public class _143重排链表 {

    public static void main(String[] args) {

    }


    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        //快慢指针分出2段
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //后端反转
        ListNode mid = slow.next;
        slow.next = null;
        mid = reverse(mid);

        //插入前端缝隙
        ListNode curr_l = head;
        while (curr_l != null && mid != null) {
            ListNode curr_l_n = curr_l.next;  //先备份 左侧当前的下一个
            ListNode curr_r = mid;
            mid = mid.next;  //右移一格

            curr_r.next = curr_l.next;
            curr_l.next = curr_r;


            curr_l = curr_l_n;  //原来的跳1个
        }
    }

    //反转, 头插法
    private ListNode reverse(ListNode head) {

        if (head == null) return head;

        ListNode newHead = head;
        while (head.next != null) {
            ListNode n = head.next;
            head.next = n.next;

            n.next = newHead;
            newHead = n;
        }
        return newHead;

    }
}
