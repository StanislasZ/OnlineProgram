package com.stan.leetcode;

public class 反转链表 {
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 5};


        ListNode l1 = new ListNode(1);
        ListNode dummy1 = l1;
        for (int i = 0; i < arr.length; i++) {
            l1.next = new ListNode(arr[i]);
            l1 = l1.next;
        }

        System.out.println(new Solution_206().reverseList_recur(dummy1));
    }
}

class Solution_206 {
    ListNode newHead = null;

    //返回是的某次reverse后的尾结点
    //递归写法
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        else {
            ListNode n = reverse(head.next);
            n.next = head;  //尾的下一个是头

            return head; //返回现在的尾
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode tail = reverse(head);
        tail.next = null;
        return newHead;
    }





    public ListNode reverseList_recur(ListNode head) {


        if (head == null) return null;
        if (head.next == null) return head;


        //head.next也不等于null，至少2个结点
        ListNode head_after_rev = reverseList_recur(head.next);
        ListNode temp_tail = head_after_rev;
        while (temp_tail.next != null) {
            temp_tail = temp_tail.next;
        }
        temp_tail.next = head;
        head.next = null;  //必须置为null，不然死循环

        return head_after_rev;
    }



    //头插法
    //leetcode143写法有点不同
    public ListNode reverseList_loop2(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;

        while (head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = left.next;
            left.next = temp;
        }
        return dummy.next;
    }


    //改变指向
    public ListNode reverseList_loop(ListNode head) {

        //1->2->3->4->5
        //第一次循环后 null<<1   ,,, 2>>3>>4>>5   new_head=1, head =2
        //第二次循环后 null<<1<<2,,,    3>>4>>5   new_head=2, head =3
        //第三次循环后 null<<1<<2<<3,,,    4>>5   …………………………

        //最后结束  null<<1<<2<<3<<4<<5   new_head=5, head =null


        if (head == null || head.next == null) return head;
        ListNode new_head = null;
        //循环的过程就是让new_head不断地变成反转后的头，从null到新的头
        while (head != null) {
            ListNode temp = head.next; //备份
            head.next = new_head;  //指向新头，也就是往左指
            new_head = head;  //更新new_head，右移一位
            head = temp;  //更新head,右移一位
        }
        return new_head;
    }
}