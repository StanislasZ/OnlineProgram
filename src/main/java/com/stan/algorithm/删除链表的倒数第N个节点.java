package com.stan.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 删除链表的倒数第N个节点 {
    public static void main(String[] args){
        Solution_19 ins =new Solution_19();

        ListNode l1Head=new ListNode(0);
        ListNode l1=l1Head;


        l1.next=new ListNode(3);
        l1=l1.next;
        l1.next=new ListNode(4);
        l1=l1.next;
        l1.next=new ListNode(5);
        l1=l1.next;

        ListNode rlt=ins.removeNthFromEnd(l1Head,2);
        System.out.println("rlt value is "+rlt.val);


    }
}

class Solution_19 {

    /**
     * 2个指针，  第一个指针先走n+1个位置， 然后2个同时走， 第一个为null时停止
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;







    }


    /**
     * 我们注意到这个问题可以容易地简化成另一个问题：
     * 删除从列表开头数起的第 (L - n + 1)(L−n+1) 个结点，其中 LL 是列表的长度。
     * 只要我们找到列表的长度 LL，这个问题就很容易解决。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        //ListNode first = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        length -= n;
        head = dummy;
        while (length > 0) {
            length--;
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;


    }
}

//在两数相加里定义过
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//    }
//}