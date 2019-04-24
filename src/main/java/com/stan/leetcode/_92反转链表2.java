package com.stan.leetcode;

public class _92反转链表2 {
}
class Solution_92 {

    //反转前，记录左边连接点，和反转部分反转前的第一个点（反转后的尾）
    //进行部分反转
    //部分反转结束后，获得反转部分的反转后的头，和右边连接点
    //左连接点.next = 反转部分反转后的头
    //反转部分反转后的尾.next = 右边连接点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left_conn = dummy;
        ListNode curr = head;

        //定位开始点
        for (int i = 1; i < m; i++) {
            left_conn = left_conn.next;
            curr = curr.next;
        }

        ListNode loop_tail = curr;   //备份，循环前的curr就是反转后的反转部分的尾

        ListNode new_head = null;
        for (int i = 1; i <= n - m + 1; i++) {
            ListNode temp = curr.next;
            curr.next = new_head;
            new_head = curr;
            curr = temp;   //出for后，？<-?<-?-<new_head , curr和左边是断的，curr就是反转部分外面的右边连接点
        }


        left_conn.next = new_head;  //左边连接点 -> 反转后反转部分的头
        loop_tail.next = curr;   //反转后反转部分的尾 -> 右边的连接

        return dummy.next;

    }
}