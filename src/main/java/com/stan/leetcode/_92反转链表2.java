package com.stan.leetcode;

public class _92反转链表2 {
}
class Solution_92 {


    /**
     * 头插法
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_2(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //左连接的节点
        ListNode left_joint = dummy;
        for (int i = 0; i < m; i++) {
            left_joint = left_joint.next;
        }

        /*
              把head右边一个搬到left_joint右边，head指向原本它的右2
         */

        head = left_joint.next;   //循环开始的位置
        for (int i = m; i < n; i++) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = left_joint.next;
            left_joint.next = temp;

        }

        return dummy.next;



    }




    //向右改成向左
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