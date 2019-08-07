package com.stan.nowcoder;



public class 两个链表的第一个公共结点 {
    public static void main(String[] args){

        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        c1.next = c2;

        ListNode pHead2 = new ListNode(4);
        ListNode p2 = pHead2;
        p2.next = new ListNode(5);
        //p2.next.next = c1;

        ListNode pHead1 = new ListNode(1);
        ListNode p1 = pHead1;
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(3);
        //p1.next.next.next = c1;
        //p1.next.next = c1;


        System.out.println(new Solution_两个链表的第一个公共结点().FindFirstCommonNode(pHead1, pHead2));

    }
}
class Solution_两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) return null;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {

            //注意： 不能写成 p1.next == null
            //这样的话 不会出现null值， 如果没有公共结点，会死循环
            p1 = p1 == null? pHead2 : p1.next;
            p2 = p2 == null? pHead1 : p2.next;

        }

        return p1;
    }
}