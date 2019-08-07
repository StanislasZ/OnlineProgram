package com.stan.nowcoder;



public class 两个链表的第一个公共结点 {
    public static void main(String[] args){

        ListNode[] l1 = new ListNode[9];
        l1[0] = new ListNode(0);
        for (int i = 1; i < l1.length; i++) {
            l1[i] = new ListNode(i);
            l1[i - 1].next = l1[i];
        }

//        ListNode pHead2 = new ListNode(5);
//        pHead2.next = l1[2];
        ListNode pHead2 = l1[6];

        ListNode pHead1 = l1[0];

        ListNode h1 = pHead1;
        ListNode h2 = pHead2;
//        while (h1 != null) {
//            System.out.println(h1);
//            h1 = h1.next;
//        }
//        System.out.println("*****");
//        while (h2 != null) {
//            System.out.println(h2);
//            h2 = h2.next;
//        }

        System.out.println(new Solution_两个链表的第一个公共结点().FindFirstCommonNode(pHead1, pHead2));

    }
}
class Solution_两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1 == null? pHead2 : p1.next;
            p2 = p2 == null? pHead1 : p2.next;
        }
        return p1;
    }
}