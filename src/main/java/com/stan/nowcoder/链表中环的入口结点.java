package com.stan.nowcoder;

public class 链表中环的入口结点 {

    public static void main(String[] args) {

    }
}
/**
 * 来源: 剑指Offer
 * 题目: 链表中环的入口节点
 *
 * 描述: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 *
 * 思路:
 * 与找倒数第 k 个结点的思路类似，还是双指针法
 * 如果链表内有环，则调整两个指针的速度，则两者必相遇
 * 因此
 * 1. i 指针的速度为1，j 指针的速度为2，视两者是否会相遇
 * 2. 若相遇，此时，继续移动j, 其必定经过 k 步重新回到 i 的位置, k便是环的长度
 * 3. 重新让i, j 指向头结点，让 j 先行 k 步，然后i, j 同行，首次相遇点便是所求
 *
 */
class Solution_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode head) {

        //先用快慢指针查看是否有环
        ListNode slow = head;
        ListNode fast = head;
        boolean hasLoop = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        if (!hasLoop) return null;  //无环，直接返回

        int len = 1;
        while (slow.next != fast) {   //一开始是相等的，不能用slow != fast
            slow = slow.next;
            len++;
        }

        //重新到开头，让一个先走len步
        slow = head;
        fast = head;
        for (int i = 0; i < len; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }
}
