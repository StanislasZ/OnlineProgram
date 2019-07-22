package com.stan.nowcoder;

public class 反转链表 {
    ListNode newHead;

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        reverse(head).next = null;
        return newHead;
    }


    //递归，返回尾
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode t = reverse(head.next);
        t.next = head;
        return head;
    }
    //********************************************************

    //循环法：依次从左到右， 把向右的指针 搞成 向左 的指针
    public ListNode ReverseList2(ListNode head) {

        ListNode tail = null;
        while (head != null) {
            ListNode temp = head.next; //备份
            head.next = tail;
            tail = head;
            head = temp;
        }
        //跳出循环时，head= null， tail才是最后一个
        return tail;

    }
    //******************************************************
    //循环法：  头插法
    public ListNode ReverseList(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) return head;

        ListNode newHead = head;  //每一次的新头
        ListNode curr = head.next;//从第二个开始，往头插
        while (curr != null) {
            ListNode temp = curr.next; //备份
            curr.next = newHead;  //插到最前面 = 让curr指向新头
            newHead = curr;  //再让curr成为新头
            curr = temp;  //改变curr，下一个
        }
        head.next = null;
        return newHead;
    }
}
