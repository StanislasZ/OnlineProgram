package com.stan.leetcode;

public class Test222 {
    public static void main(String[] args) {





        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);


        System.out.println(reverseBetween(l1, 2, 3));


    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //找到左连接位置
        ListNode left_c = dummy;

        for (int i = 0; i < m-1; i++) {
            left_c = left_c.next;
        }
        System.out.println("left_c is " + left_c);


        ListNode loop_head = left_c.next;
        System.out.println("开始前，loop_head = " + loop_head);
        ListNode after_tail = loop_head;

        ListNode loop_t = null;

        int k = n-m;
        System.out.println("n=" + n +", m= " +m + ", k = " + k);
        while (k-- != 0) {
            System.out.println("k = " + k);
            ListNode temp = loop_head.next; //备份下一个
            loop_head.next = loop_t;
            loop_t = loop_head;
            loop_head = temp;
        }


        left_c.next = loop_t;

        after_tail.next = loop_head;



        return dummy.next;

    }
}
