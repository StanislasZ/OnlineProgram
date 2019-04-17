package com.stan.algorithm;

public class 旋转链表 {
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 5};


        ListNode l1 = new ListNode(1);
        ListNode dummy1 = l1;
        for (int i = 0; i < arr.length; i++) {
            l1.next = new ListNode(arr[i]);
            l1 = l1.next;
        }


        ListNode rlt = new Solution_61().rotateRight(dummy1, 2);
        System.out.println("***");
        while (rlt != null) {
            System.out.println(rlt);
            rlt = rlt.next;
        }

    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head  == null) return null;
        if (head.next == null) return head;

        int size = size(head);
        System.out.println("size = "+size);
        k = k % size;
        System.out.println("size = "+size+" , k = "+k);

        ListNode h = head;



        for (int i = 0; i < k; i++) {
            head = rotateOnce(head);
        }
        return head;
    }

    //右移一次
    public static ListNode rotateOnce(ListNode head) {


        ListNode head_before = head;
        ListNode h_pre = new ListNode(0);
        h_pre.next = head;
        ListNode h = head;
        while (h.next != null) {
            h_pre = h_pre.next;
            h = h.next;
        }
        //h为原来的tail , h_pre为原来的tail的前一个
        h.next = head_before;
        h_pre.next = null;

        return h;


    }
    public static int size(ListNode head) {

        int cnt = 0;

        ListNode h = head;
        while (h != null) {
            cnt++;
            h = h.next;
        }
        return cnt;

    }
}
