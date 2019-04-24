package com.stan.leetcode;

public class 相交链表 {
    public static void main(String[] args){

    }
}

class Solution_161 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //如果a和b的长度不相等，那么下面的循环会循环两次，第一次循环后把两个链表的指针交换，同时完成末端对齐。大神就是大神。。
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;



    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */