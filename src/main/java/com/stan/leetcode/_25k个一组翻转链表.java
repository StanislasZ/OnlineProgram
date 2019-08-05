package com.stan.leetcode;

public class _25k个一组翻转链表 {
    public static void main(String[] args){

        /*
            给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
            k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

            示例 :

            给定这个链表：1->2->3->4->5
            当 k = 2 时，应当返回: 2->1->4->3->5
            当 k = 3 时，应当返回: 3->2->1->4->5

            说明 :
            你的算法只能使用常数的额外空间。
            你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
         */


    }

}
class Solution_25 {




    /**
     * 循环，头插法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_loop(ListNode head, int k) {
        //特殊输入
        if (head == null || head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;  //前一段的尾

        while (head != null) {

            //判断这一段长度是不是够
            ListNode h = head;
            for (int i = 0; i < k; ++i) {
                if (h == null) {
                    pre.next = head;
                    return dummy.next;
                }
                h = h.next;
            }
            ListNode n = h;  //下一段的头
            //这一段头插法
            h = head;
            ListNode curr = h.next;
            while (curr != n) {
                ListNode temp = curr.next;  //备份
                curr.next = h;
                h = curr;  //更换新头
                curr = temp;
            }
            pre.next = h;  //上一段尾 -> 这一段的新头
            head.next = curr;   //这一段的新尾(旧头head) -> 下一段的头(curr)

            //更新
            pre = head;
            head = curr;

        }
        return dummy.next;

    }






}

