package com.stan.leetcode;

public class _142环形链表2 {

    public static void main(String[] args) {
        _142环形链表2 a = new _142环形链表2();

    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        //1. 判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCircle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        //无环，返回
        if (!hasCircle) return null;

        //相遇点到入口点和head到入口点距离相等， 可证
        //2*distance(慢） = distance(快） 写一下，化简即可

        //剪纸offer里还要计算环的长度len，让一个先走len步，然后一起走，垃圾

        ListNode slow2 = head;
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;


    }

}
