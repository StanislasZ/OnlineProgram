package com.stan.leetcode;

public class 两两交换链表中的节点 {
    public static void main(String[] args){

        /*
            给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

            示例:

            给定 1->2->3->4, 你应该返回 2->1->4->3.
            说明:

            你的算法只能使用常数的额外空间。
            你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
         */

        ListNode l1Head=new ListNode(0);
        ListNode l1=l1Head;


        l1.next=new ListNode(1);
        l1=l1.next;
        l1.next=new ListNode(2);
        l1=l1.next;
        l1.next=new ListNode(3);
        l1=l1.next;



    }
}


class Solution_24 {


    /**
     * 若该节点为NULL，则直接返回NULL
     * 若该节点的下一个节点为NULL，则直接返回该节点
     * 交换该节点与下一个节点，利用辅助指针记录该节点的下一个节点，并递归的交换接下来的节点对
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if(head==null) return null;
        if(head.next==null) return head;

        ListNode temp = head.next;//本来的第二个

        head.next = swapPairs(temp.next);  //第一个指向第三个 （递归）
        temp.next = head;     //第二个指向第一个

        return temp;
    }
}